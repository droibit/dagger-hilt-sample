package com.example.dagger_hilt.core.data.source

interface SampleSource {

    suspend fun getSampleText(): String
}