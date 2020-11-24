package com.example.dagger_hilt.feature.other

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object OtherViewModelModule {
    @Named("otherText")
    @Provides
    fun provideText(handle: SavedStateHandle): String {
        return requireNotNull(handle["text"])
    }
}