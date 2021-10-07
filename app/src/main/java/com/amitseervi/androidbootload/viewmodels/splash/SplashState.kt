package com.amitseervi.androidbootload.viewmodels.splash

import com.amitseervi.androidbootload.exceptions.BaseException
import com.amitseervi.androidbootload.models.app.NavigationAction

data class SplashState(
    val loading: Boolean = false,
    val error: BaseException? = null,
    val navAction: NavigationAction? = null
)