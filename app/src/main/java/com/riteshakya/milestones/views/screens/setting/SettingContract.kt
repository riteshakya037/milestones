package com.riteshakya.milestones.views.screens.setting

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView


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