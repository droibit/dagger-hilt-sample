package com.example.dagger_hilt.feature.other

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger_hilt.databinding.ActivityOtherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtherBinding

    private val viewModel: OtherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.text.observe(this) {
            binding.text.text = it
        }
    }
}