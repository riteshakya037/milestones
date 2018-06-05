package com.ydl.android.views.screens.create.goal

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView


interface CreateGoalContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View>
}