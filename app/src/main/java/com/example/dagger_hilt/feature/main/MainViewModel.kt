package com.example.dagger_hilt.feature.main

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt.core.data.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel(
    private val sampleRepository: SampleRepository,
    private val toastMessageSink: MutableLiveData<String>
) : ViewModel() {

    val toastMessage: LiveData<String> get() = toastMessageSink

    @Inject
    constructor(
        sampleRepository: SampleRepository
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