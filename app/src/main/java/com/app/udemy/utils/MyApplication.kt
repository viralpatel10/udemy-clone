package com.app.udemy.utils

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.app.udemy.preferences.SharedPreferencesMain

class MyApplication : Application() {

    companion object {
        private var instance: MyApplication? = null

        @JvmStatic
        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        SharedPreferencesMain.init(this)
    }
}
