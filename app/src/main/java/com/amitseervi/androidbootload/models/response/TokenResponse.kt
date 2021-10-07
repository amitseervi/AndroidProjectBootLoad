package com.amitseervi.androidbootload.models.response

import com.squareup.moshi.Json

data class TokenResponse(
    @field:Json(name = "refreshToken") val refreshToken: String?,
    @field:Json(name = "token") val token: String?
)