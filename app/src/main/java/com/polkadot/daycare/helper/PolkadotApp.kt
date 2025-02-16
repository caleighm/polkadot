package com.polkadot.daycare.helper

import android.app.Application
import androidx.navigation.NavHostController
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PolkadotApp : Application() {
    lateinit var navController: NavHostController

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        lateinit var context: PolkadotApp
    }
}

