package com.example.diploma

import android.app.Application
import com.example.diploma.di.initKoin
import org.koin.android.ext.koin.androidContext

class DiplomaApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@DiplomaApp)
        }
    }
}