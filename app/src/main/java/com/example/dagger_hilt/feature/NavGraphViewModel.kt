package com.example.dagger_hilt.feature

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.dagger_hilt.core.data.repository.SampleRepository

class NavGraphViewModel @ViewModelInject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {

    init {
        TODO("Dagger hilt with `#navGraphViewModels`")
    }
}