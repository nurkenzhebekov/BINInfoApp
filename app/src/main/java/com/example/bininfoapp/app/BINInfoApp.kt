package com.example.bininfoapp.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BINInfoApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}