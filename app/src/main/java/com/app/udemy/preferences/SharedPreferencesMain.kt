package com.app.udemy.preferences

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences


object SharedPreferencesMain {
    private lateinit var mSharedPref: SharedPreferences

    fun init(context: Context) {
        if (!SharedPreferencesMain::mSharedPref.isInitialized) {
            mSharedPref = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
        }
    }

    fun getString(key: String, defValue: String? = null): String? =
        mSharedPref.getString(key, defValue)

    fun putString(key: String, value: String?) {
        mSharedPref.edit().apply { putString(key, value) }.apply()
    }

    fun getInt(key: String, defValue: Int = 0): Int =
        mSharedPref.getInt(key, defValue)

    fun putInt(key: String, value: Int) {
        mSharedPref.edit().apply { putInt(key, value) }.apply()
    }

    fun getBoolean(key: String, defValue: Boolean = false): Boolean =
        mSharedPref.getBoolean(key, defValue)

    fun putBoolean(key: String, value: Boolean) {
        mSharedPref.edit().apply { putBoolean(key, value) }.apply()
    }

    fun getLong(key: String, defValue: Long = 0L): Long =
        mSharedPref.getLong(key, defValue)

    fun putLong(key: String, value: Long) {
        mSharedPref.edit().apply { putLong(key, value) }.apply()
    }

    fun getFloat(key: String, defValue: Float = 0f): Float =
        mSharedPref.getFloat(key, defValue)

    fun putFloat(key: String, value: Float) {
        mSharedPref.edit().apply { putFloat(key, value) }.apply()
    }

    fun clearPreferences() {
        mSharedPref.edit().apply { clear() }.apply()
    }

    fun removePreference(key: String) {
        mSharedPref.edit().apply { remove(key) }.apply()
    }
}

