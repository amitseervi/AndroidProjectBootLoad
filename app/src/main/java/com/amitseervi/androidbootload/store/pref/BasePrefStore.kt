package com.amitseervi.androidbootload.store.pref

import android.content.SharedPreferences

abstract class BasePrefStore {
    abstract val sharedPreferences: SharedPreferences

    fun getString(key: String, default: String? = null): String? {
        return sharedPreferences.getString(key, default)
    }

    fun getBoolean(key: String, default: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, default)
    }

    fun getInt(key: String, default: Int = 0): Int {
        return sharedPreferences.getInt(key, default)
    }

    fun getFloat(key: String, default: Float = 0f): Float {
        return sharedPreferences.getFloat(key, default)
    }

    fun putString(key: String, value: String? = null) {
        val editor = sharedPreferences.edit()
        try {
            editor.putString(key, value)
        } catch (e: Exception) {
            editor.apply()
        }
    }

    fun putInt(key: String, value: Int = 0) {
        val editor = sharedPreferences.edit()
        try {
            editor.putInt(key, value)
        } catch (e: Exception) {
            editor.apply()
        }
    }

    fun putBoolean(key: String, value: Boolean = false) {
        val editor = sharedPreferences.edit()
        try {
            editor.putBoolean(key, value)
        } catch (e: Exception) {
            editor.apply()
        }
    }

    fun putFloat(key: String, value: Float = 0f) {
        val editor = sharedPreferences.edit()
        try {
            editor.putFloat(key, value)
        } catch (e: Exception) {
            editor.apply()
        }
    }
}