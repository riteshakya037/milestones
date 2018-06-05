package com.ydl.android.views.screens.landing.forgotpass

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView

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