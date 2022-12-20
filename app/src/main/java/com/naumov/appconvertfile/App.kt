package com.naumov.appconvertfile

import android.app.Application
import android.content.Context

class App:Application() {


    override fun onCreate() {
        super.onCreate()
    }

}
val Context.app: App get() = applicationContext as App
