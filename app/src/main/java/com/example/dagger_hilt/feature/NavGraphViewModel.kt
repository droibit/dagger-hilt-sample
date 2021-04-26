package com.example.dagger_hilt.feature

import androidx.lifecycle.ViewModel
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.dagger_hilt.background.SampleWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavGraphViewModel @Inject constructor(
    private val workManager: WorkManager
) : ViewModel() {

    fun enqueueWork() {
        val request = OneTimeWorkRequestBuilder<SampleWorker>().build()
        workManager.enqueue(request)
    }
}