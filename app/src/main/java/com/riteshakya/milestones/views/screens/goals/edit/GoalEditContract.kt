package com.riteshakya.milestones.views.screens.goals.edit

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView
import com.riteshakya.milestones.data.remote.goals.Goal


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