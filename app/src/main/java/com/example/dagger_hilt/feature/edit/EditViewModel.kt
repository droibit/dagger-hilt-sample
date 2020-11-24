package com.example.dagger_hilt.feature.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class EditViewModel(
    textSink: MutableLiveData<String>
) : ViewModel() {

    val text: LiveData<String> = textSink

    @Inject
    constructor(
        @Named("editId") detailId: String
    ) : this(
        MutableLiveData(detailId)
    )
}