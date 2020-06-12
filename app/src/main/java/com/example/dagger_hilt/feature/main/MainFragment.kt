package com.example.dagger_hilt.feature.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.dagger_hilt.R
import com.example.dagger_hilt.feature.main.MainFragmentDirections.Companion.toDetailFragment
import com.example.dagger_hilt.feature.main.MainFragmentDirections.Companion.toOtherActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.toastMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        showToastButton.setOnClickListener {
            viewModel.onShowToastButtonClick()
        }

        showDetailButton.setOnClickListener {
            findNavController().navigate(toDetailFragment(detailId ="detail-01" ))
        }

        showOtherButton.setOnClickListener {
            findNavController().navigate(toOtherActivity(text = "Show OtherActivity"))
        }
    }
}