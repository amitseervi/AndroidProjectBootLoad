package com.amitseervi.androidbootload.store.pref

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPrefStore @Inject constructor(private val application: Application) : BasePrefStore() {
    override val sharedPreferences: SharedPreferences =
        application.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREF_NAME = "user_pref"

        const val TOKEN = "token"
        const val REFRESH_TOKEN = "refresh_token"
        const val USER_DATA = "user_data"
    }
}