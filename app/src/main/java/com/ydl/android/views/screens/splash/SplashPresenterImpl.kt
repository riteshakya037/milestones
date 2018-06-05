package com.ydl.android.views.screens.splash

import com.ydl.android.base.BaseRxPresenter
import com.ydl.android.data.remote.session.SessionManager
import javax.inject.Inject

class SplashPresenterImpl
@Inject constructor(
        private val sessionManager: SessionManager
) : BaseRxPresenter(), SplashContract.Presenter {

    private lateinit var splashView: SplashContract.View

    override fun setView(view: SplashContract.View) {
        this.splashView = view
    }

    override fun subscribe() {
        getSession()
    }

    private fun getSession() {
        if (sessionManager.hasSession) {
            splashView.navigateToMainScreen()
        } else {
            splashView.navigateToLandingScreen()
        }
    }
}