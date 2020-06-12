package com.example.dagger_hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Named("debuggable")
    @Provides
    fun provideDebuggable(): Boolean {
        return BuildConfig.DEBUG
    }
}