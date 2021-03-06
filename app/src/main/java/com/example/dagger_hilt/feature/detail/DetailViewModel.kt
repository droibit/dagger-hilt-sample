package com.example.dagger_hilt.feature.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DetailViewModel(
    textSink: MutableLiveData<String>
) : ViewModel() {

    val text: LiveData<String> = textSink

    @Inject
    constructor(
        @Named("detailId") detailId: String
    ) : this(
        MutableLiveData(detailId)
    )
}