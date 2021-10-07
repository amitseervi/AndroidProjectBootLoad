package com.amitseervi.androidbootload.models.interceptors

import com.amitseervi.androidbootload.store.pref.UserPrefStore
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeaderInterceptor @Inject constructor(private val userPrefStore: UserPrefStore) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.addHeader(TOKEN_HEADER, userPrefStore.getString(UserPrefStore.TOKEN) ?: "")
        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val TOKEN_HEADER = "token"
    }
}