package com.example.dagger_hilt.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.example.dagger_hilt.R
import com.example.dagger_hilt.databinding.FragmentMainBinding
import com.example.dagger_hilt.feature.NavGraphViewModel
import com.example.dagger_hilt.feature.main.MainFragmentDirections.Companion.toDetailFragment
import com.example.dagger_hilt.feature.main.MainFragmentDirections.Companion.toEditFragment
import com.example.dagger_hilt.feature.main.MainFragmentDirections.Companion.toOtherActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel: MainViewModel by viewModels()

    private val navGraphViewModel: NavGraphViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.toastMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        binding.showToastButton.setOnClickListener {
            viewModel.onShowToastButtonClick()
        }

        binding.showDetailButton.setOnClickListener {
            findNavController().navigate(toDetailFragment(detailId = "detail-01"))
        }

        binding.showEditButton.setOnClickListener {
            findNavController().navigate(toEditFragment(editId = "edit-02"))
        }

        binding.showOtherButton.setOnClickListener {
            findNavController().navigate(toOtherActivity(text = "Show OtherActivity"))
        }

        navGraphViewModel.enqueueWork()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}