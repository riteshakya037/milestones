package com.ydl.android.views.screens.landing.login

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView

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