package com.riteshakya.milestones.views.screens.landing.login

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView

interface LoginContract {

    interface View : BaseView {

        fun onLoginSuccess()

        fun onLoginFailed(throwable: Throwable)

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View> {

        fun login(email: String, password: String)

    }
}