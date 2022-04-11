package com.example.happybirthday.busschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.MyApplication
import com.example.happybirthday.R
import com.example.happybirthday.busschedule.adapter.BusStopAdapter
import com.example.happybirthday.busschedule.viewmodel.BusScheduleViewModel
import com.example.happybirthday.busschedule.viewmodel.BusScheduleViewModelFactory
import com.example.happybirthday.databinding.FragmentFullScheduleBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FullScheduleFragment: Fragment() {

    private var _binding: FragmentFullScheduleBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val viewModel: BusScheduleViewModel by activityViewModels {
        BusScheduleViewModelFactory((activity?.application as MyApplication).database.scheduleDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFullScheduleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val busStopAdapter = BusStopAdapter {
            val action =
                FullScheduleFragmentDirections.actionFullScheduleFragmentToStopScheduleFragment(it.stopName)
            view.findNavController().navigate(action)
        }
        recyclerView.adapter = busStopAdapter

        // submitList() is a call that accesses the database. To prevent the
        // call from potentially locking the UI, you should use a
        // coroutine scope to launch the function. Using GlobalScope is not
        // best practice, and in the next step we'll see how to improve this.
        GlobalScope.launch(Dispatchers.IO) {
            busStopAdapter.submitList(viewModel.fullSchedule())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}