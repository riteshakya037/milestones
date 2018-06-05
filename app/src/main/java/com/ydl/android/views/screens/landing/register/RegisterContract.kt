package com.ydl.android.views.screens.landing.register

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView

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