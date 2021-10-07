package com.amitseervi.androidbootload.models.app

import com.amitseervi.androidbootload.models.response.UserStateResponse
import com.squareup.moshi.Json

data class SessionState(
    @field:Json(name = "loggedIn") val loggedIn: Boolean,
    @field:Json(name = "userState") val userState: UserStateResponse?
)