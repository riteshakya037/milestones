package com.ydl.android.views.screens.setting

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView


interface SettingContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun setEmail(it: String)

        fun closeScreen()
    }

    interface Presenter : BasePresenter<View> {
        fun changePassword(email: String, password: String)
    }
}