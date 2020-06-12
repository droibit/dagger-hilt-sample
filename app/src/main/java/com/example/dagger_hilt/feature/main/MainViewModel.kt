package com.example.dagger_hilt.feature.main

import androidx.annotation.UiThread
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt.core.data.repository.SampleRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val sampleRepository: SampleRepository,
    private val toastMessageSink: MutableLiveData<String>
) : ViewModel() {

    val toastMessage: LiveData<String> get() = toastMessageSink

    @ViewModelInject
    constructor(
        sampleRepository: SampleRepository
        //    @Assisted private val savedStateHandle: SavedStateHandle
    ) : this(
        sampleRepository,
        MutableLiveData()
    )

    @UiThread
    fun onShowToastButtonClick() {
        viewModelScope.launch {
            val text = sampleRepository.getText()
            toastMessageSink.value = text
        }
    }
}