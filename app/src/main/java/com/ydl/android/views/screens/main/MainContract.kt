package com.ydl.android.views.screens.main

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView


interface MainContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun createNewGoal()

        fun setCurrentGoals(completedCount: Int)

        fun setTotalGoals(size: Int)

    }

    interface Presenter : BasePresenter<View> {
    }
}