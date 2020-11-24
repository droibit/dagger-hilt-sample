package com.example.dagger_hilt.core.di

import android.content.Context
import android.content.SharedPreferences
import com.example.dagger_hilt.core.data.source.LocalSampleSource
import com.example.dagger_hilt.core.data.source.SampleSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Named("SamplePrefs")
    @Provides
    fun provideSampleSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("sample", Context.MODE_PRIVATE)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindingModule {

        @Named("Local")
        @Binds
        fun bindSampleSource(source: LocalSampleSource): SampleSource
    }
}