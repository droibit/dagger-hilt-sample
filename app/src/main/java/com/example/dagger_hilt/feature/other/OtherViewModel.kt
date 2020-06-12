package com.example.dagger_hilt.feature.other

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class OtherViewModel(
    private val textSink: MutableLiveData<String>
) : ViewModel() {

    val text: LiveData<String> = textSink

    @ViewModelInject
    constructor(
        @Assisted savedState: SavedStateHandle
    ) : this(
        MutableLiveData(
            requireNotNull(savedState["text"])
        )
    )
}