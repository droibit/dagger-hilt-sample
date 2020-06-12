package com.example.dagger_hilt.core.data.repository

import com.example.dagger_hilt.core.data.CoroutinesDispatcherProvider
import com.example.dagger_hilt.core.data.source.SampleSource
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class SampleRepository @Inject constructor(
    @Named("Local") private val localSampleSource: SampleSource,
    private val dispatcherProvider: CoroutinesDispatcherProvider
) {
    suspend fun getText(): String {
        return withContext(dispatcherProvider.computation) {
            localSampleSource.getSampleText()
        }
    }
}