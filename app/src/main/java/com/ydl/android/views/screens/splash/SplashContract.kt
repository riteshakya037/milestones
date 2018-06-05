package com.ydl.android.views.screens.splash

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView

interface SplashContract {

    interface View : BaseView {

        fun navigateToLandingScreen()

        fun onConfigLoadFailed(throwable: Throwable)

        fun navigateToMainScreen()

    }

    interface Presenter : BasePresenter<View>

}