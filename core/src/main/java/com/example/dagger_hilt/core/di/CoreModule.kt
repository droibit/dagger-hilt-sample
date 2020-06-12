package com.example.dagger_hilt.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import timber.log.Timber
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object CoreModule {

    @Provides
    fun provideTimberTree(@Named("debuggable") debug: Boolean): Timber.Tree =
        if (debug) Timber.DebugTree() else {
            object : Timber.Tree() {
                override fun log(
                    priority: Int,
                    tag: String?,
                    message: String,
                    t: Throwable?
                ) = Unit
            }
        }
}