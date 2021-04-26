package com.example.dagger_hilt.background

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.dagger_hilt.core.data.repository.SampleRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class SampleWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val sampleRepository: SampleRepository
): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        val text = sampleRepository.getText()
        Timber.d("$text @background.")
        return Result.success()
    }
}