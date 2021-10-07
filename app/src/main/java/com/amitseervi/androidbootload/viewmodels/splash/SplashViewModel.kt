package com.amitseervi.androidbootload.viewmodels.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.amitseervi.androidbootload.models.app.NavigationAction
import com.amitseervi.androidbootload.models.app.RepositoryResultStatus
import com.amitseervi.androidbootload.repository.SessionRepository
import com.amitseervi.androidbootload.ui.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sessionRepository: SessionRepository) :
    ViewModel() {
    private val viewModelCoroutineContext = SupervisorJob() + Dispatchers.Main
    private val viewModelScope = CoroutineScope(viewModelCoroutineContext)

    val splashState: LiveData<SplashState> =
        Transformations.map(sessionRepository.sessionStateResult) {
            if (it.status == RepositoryResultStatus.LOADED) {
                if (it.error != null) {
                    SplashState(navAction = NavigationAction(Routes.HOME))
                } else {
                    SplashState(error = it.error)
                }
            } else if (it.status == RepositoryResultStatus.IN_PROGRESS) {
                SplashState(loading = true)
            } else {
                SplashState()
            }
        }

    fun startLoading() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                sessionRepository.fetchUserSession()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel("View model cleared")
    }

}