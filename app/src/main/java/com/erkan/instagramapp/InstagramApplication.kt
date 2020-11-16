package com.erkan.instagramapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by umiterkan on 11/10/2020
 */

@HiltAndroidApp
class InstagramApplication :Application(){

    override fun onCreate() {
        super.onCreate()
    }
}