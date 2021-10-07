package com.amitseervi.androidbootload.models.response


import com.amitseervi.androidbootload.models.app.UserData
import com.squareup.moshi.Json

data class UserStateResponse(
    @field:Json(name = "token") val token: TokenResponse?,
    @field:Json(name = "user") val user: UserData
)