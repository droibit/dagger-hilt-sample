package com.example.dagger_hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class SampleApplication : Application() {

    @Inject
    fun bootstrap(timberTree: Timber.Tree) {
        Timber.plant(timberTree)

        Timber.d("Bootstrap")
    }
}