package com.amitseervi.androidbootload.ui.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amitseervi.androidbootload.ui.Routes
import com.amitseervi.androidbootload.ui.screens.splash.SplashComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.i("amittest","Settigng main activity content")
            val navHostController = rememberNavController()
            NavHost(
                navController = navHostController,
                startDestination = Routes.SPLASH
            ) {
                composable(Routes.SPLASH) {
                    SplashComposable(navController = navHostController)
                }
            }
        }
    }
}