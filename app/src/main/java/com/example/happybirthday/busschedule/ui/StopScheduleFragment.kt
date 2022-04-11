package com.example.happybirthday.busschedule.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.happybirthday.MyApplication
import com.example.happybirthday.busschedule.adapter.BusStopAdapter
import com.example.happybirthday.busschedule.viewmodel.BusScheduleViewModel
import com.example.happybirthday.busschedule.viewmodel.BusScheduleViewModelFactory
import com.example.happybirthday.databinding.FragmentStopScheduleBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StopScheduleFragment: Fragment() {

    companion object {
        var STOP_NAME = "stopName"
    }

    private var _binding: FragmentStopScheduleBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private lateinit var stopName: String

    private val viewModel: BusScheduleViewModel by activityViewModels {
        BusScheduleViewModelFactory(
            (activity?.application as MyApplication).database.scheduleDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            stopName = it.getString(STOP_NAME).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStopScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val busStopAdapter = BusStopAdapter({})
        recyclerView.adapter = busStopAdapter

        GlobalScope.launch(Dispatchers.IO) {
            busStopAdapter.submitList(viewModel.scheduleForStopName(stopName))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}