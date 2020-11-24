package com.example.dagger_hilt.feature.detail

import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
object DetailViewModelModule {
    @Named("detailId")
    @Provides
    fun provideDetailId(handle: SavedStateHandle): String {
        return requireNotNull(handle["detailId"])
    }
}