package com.ydl.android.views.screens.goals.edit

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView
import com.ydl.android.data.remote.goals.Goal


interface GoalEditContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun displayGoal(goal: Goal)
        fun closeScreen()
    }

    interface Presenter : BasePresenter<View> {
        fun getGoalForId(goalId: String)
        fun updateGoal(goal: Goal)
    }
}