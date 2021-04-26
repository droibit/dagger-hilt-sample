package com.example.dagger_hilt.feature

import androidx.lifecycle.ViewModel
import com.example.dagger_hilt.core.data.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NavGraphViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {

    fun doSomething() {
        Timber.d("TODO: Do something")
    }
}