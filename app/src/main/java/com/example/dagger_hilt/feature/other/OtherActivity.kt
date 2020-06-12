package com.example.dagger_hilt.feature.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.example.dagger_hilt.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_other.*

@AndroidEntryPoint
class OtherActivity : AppCompatActivity(R.layout.activity_other) {

    private val viewModel: OtherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.text.observe(this) {
            text.text = it
        }
    }
}