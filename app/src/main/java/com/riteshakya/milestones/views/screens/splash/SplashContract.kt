package com.riteshakya.milestones.views.screens.splash

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView

interface SplashContract {

    interface View : BaseView {

        fun navigateToLandingScreen()

        fun onConfigLoadFailed(throwable: Throwable)

        fun navigateToMainScreen()

    }

    interface Presenter : BasePresenter<View>

}