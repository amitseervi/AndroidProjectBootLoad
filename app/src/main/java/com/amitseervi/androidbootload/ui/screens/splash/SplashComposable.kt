package com.amitseervi.androidbootload.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Transformations
import androidx.navigation.NavController
import com.amitseervi.androidbootload.viewmodels.splash.SplashViewModel

@Composable
fun SplashComposable(navController: NavController) {
    val splashViewModel: SplashViewModel = hiltViewModel<SplashViewModel>()
    splashViewModel.startLoading()
    Scaffold(
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                content = {
                    SplashProgressComposable(splashViewModel)
                }
            )
        })
}

@Composable
private fun SplashProgressComposable(
    viewModel: SplashViewModel
) {
    val splashState: State<Boolean?> = Transformations.map(viewModel.splashState) {
        it?.loading == true
    }.observeAsState()
    val splashLoading = splashState.value
    if (splashLoading == true) {
        CircularProgressIndicator()
    }
}