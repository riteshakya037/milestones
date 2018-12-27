package com.riteshakya.milestones.views.screens.landing.register

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView

interface RegisterContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun onRegisterSuccess()

        fun onRegisterFailed(throwable: Throwable)

    }

    interface Presenter : BasePresenter<View> {

        fun register(email: String, password: String)

    }
}