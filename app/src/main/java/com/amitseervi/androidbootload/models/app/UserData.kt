package com.amitseervi.androidbootload.models.app

import com.squareup.moshi.Json

data class UserData(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "email") val email: String
)