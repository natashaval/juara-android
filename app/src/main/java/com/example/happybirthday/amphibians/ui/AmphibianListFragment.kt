package com.example.happybirthday.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.happybirthday.R
import com.example.happybirthday.amphibians.adapter.AmphibianListAdapter
import com.example.happybirthday.amphibians.adapter.AmphibianListener
import com.example.happybirthday.amphibians.viewmodel.AmphibianViewModel
import com.example.happybirthday.databinding.FragmentAmphibianListBinding

class AmphibianListFragment : Fragment() {

    private val viewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAmphibianListBinding.inflate(inflater)
        // TODO: call the view model method that calls the amphibians api
        viewModel.getAmphibianList()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
            viewModel.onAmphibianClicked(amphibian)
            findNavController()
                .navigate(R.id.action_amphibianListFragment_to_amphibianDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}