package com.example.dagger_hilt.feature.other

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class OtherViewModel(
    textSink: MutableLiveData<String>
) : ViewModel() {

    val text: LiveData<String> = textSink

    @Inject
    constructor(
        @Named("otherText") text: String
    ) : this(
        MutableLiveData(text)
    )
}