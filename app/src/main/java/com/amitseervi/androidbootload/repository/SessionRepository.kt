package com.amitseervi.androidbootload.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amitseervi.androidbootload.models.api.HttpCode
import com.amitseervi.androidbootload.models.api.MyAppApi
import com.amitseervi.androidbootload.models.app.RepositoryResult
import com.amitseervi.androidbootload.models.app.SessionState
import com.amitseervi.androidbootload.store.pref.UserPrefStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository @Inject constructor(
    private val api: MyAppApi,
    private val userPrefStore: UserPrefStore
) {
    private val _sessionStateResult = MutableLiveData<RepositoryResult<SessionState>>()
    val sessionStateResult: LiveData<RepositoryResult<SessionState>>
        get() = _sessionStateResult

    suspend fun fetchUserSession() {
        _sessionStateResult.postValue(RepositoryResult.loading())
        val token = userPrefStore.getString(UserPrefStore.REFRESH_TOKEN)
        val response = api.getUserState(token)
        if (response.isSuccessful && response.code() == HttpCode.OK.code) {
            val responseBody = response.body()
            if (responseBody != null) {
                updatePrefStore(responseBody)
                _sessionStateResult.postValue(RepositoryResult.ok(responseBody))
            } else {
                _sessionStateResult.postValue(RepositoryResult.notFound())
            }
        } else {
            _sessionStateResult.postValue(RepositoryResult.errorFromHttpCode(response.code()))
        }
    }

    private fun updatePrefStore(userStateResponse: SessionState) {
        userStateResponse.userState?.token?.let { tokenResponse ->
            userPrefStore.putString(UserPrefStore.TOKEN, tokenResponse.token)
            userPrefStore.putString(UserPrefStore.REFRESH_TOKEN, tokenResponse.refreshToken)
        }
    }
}