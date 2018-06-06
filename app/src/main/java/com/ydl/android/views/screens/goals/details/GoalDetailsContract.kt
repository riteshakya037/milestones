package com.ydl.android.views.screens.goals.details

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView
import com.ydl.android.data.remote.goals.Goal


interface GoalDetailsContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun displayGoal(goal: Goal)
    }

    interface Presenter : BasePresenter<View> {
        fun getGoalForId(goalId: String)
    }
}