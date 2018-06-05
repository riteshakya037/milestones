package com.ydl.android.views.screens.create.confirmation

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView


interface GoalConfirmationContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View>
}