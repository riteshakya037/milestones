package com.riteshakya.milestones.views.screens.landing.forgotpass

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView

interface ForgotPasswordContract {

    interface View : BaseView {

        fun onResetPasswordSuccess()

        fun onResetPasswordFailed(throwable: Throwable)

        fun showInAppError(message: String)
    }

    interface Presenter : BasePresenter<View> {

        fun resetPassword(email: String)

    }
}