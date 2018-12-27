package com.riteshakya.milestones.views.screens.main

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView


interface MainContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun createNewGoal()

        fun setCurrentGoals(completedCount: Int)

        fun setTotalGoals(size: Int)

        fun navigateToSplashScreen()

    }

    interface Presenter : BasePresenter<View> {
        fun logOut()
    }
}