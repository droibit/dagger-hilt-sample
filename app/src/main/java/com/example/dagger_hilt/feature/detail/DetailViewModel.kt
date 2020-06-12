package com.example.dagger_hilt.feature.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class DetailViewModel(
    private val textSink: MutableLiveData<String>
) : ViewModel() {

    val text: LiveData<String> = textSink

    @ViewModelInject
    constructor(
        @Assisted savedState: SavedStateHandle
    ) : this(
        MutableLiveData(
            requireNotNull(savedState["detailId"])
        )
    )
}