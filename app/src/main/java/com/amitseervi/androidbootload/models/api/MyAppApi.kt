package com.amitseervi.androidbootload.models.api

import com.amitseervi.androidbootload.models.app.SessionState
import com.amitseervi.androidbootload.models.app.UserData
import com.amitseervi.androidbootload.models.payload.LoginPayload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyAppApi {
    @POST("/api/login")
    suspend fun loginUser(
        @Body payload: LoginPayload
    ): Response<UserData>

    @GET("/api/state")
    suspend fun getUserState(@Header("refresh-token") refreshToken: String?): Response<SessionState>
}