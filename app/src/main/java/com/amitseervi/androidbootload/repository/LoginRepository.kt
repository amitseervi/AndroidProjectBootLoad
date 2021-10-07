package com.amitseervi.androidbootload.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amitseervi.androidbootload.models.api.MyAppApi
import com.amitseervi.androidbootload.models.app.RepositoryResult
import com.amitseervi.androidbootload.models.app.UserData
import com.amitseervi.androidbootload.models.payload.LoginPayload
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val api: MyAppApi
) {
    private val _loginResult: MutableLiveData<RepositoryResult<UserData>> = MutableLiveData()

    val loginResult: LiveData<RepositoryResult<UserData>>
        get() = _loginResult

    suspend fun loginUser(email: String, password: String) {
        api.loginUser(LoginPayload(email = email, password = password))
    }
}