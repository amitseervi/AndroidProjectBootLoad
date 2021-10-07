package com.amitseervi.androidbootload.models.app

data class NavigationAction(
    val target: String,
    val params: Map<String, String>? = null
)