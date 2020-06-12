package com.example.dagger_hilt.core.data.source

import android.content.SharedPreferences
import kotlinx.coroutines.suspendAtomicCancellableCoroutine
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Singleton
class LocalSampleSource @Inject constructor(
    @Named("SamplePrefs") private val sharedPrefs: SharedPreferences
): SampleSource {

    override suspend fun getSampleText(): String {
        return suspendCoroutine { cont ->
            val text = sharedPrefs.getString("sample_key", "Hello, Dagger-Hilt!")
            cont.resume(requireNotNull(text))
        }
    }
}