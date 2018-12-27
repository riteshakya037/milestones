package com.riteshakya.milestones.views.screens.goals.details

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView
import com.riteshakya.milestones.data.remote.goals.Goal


interface GoalDetailsContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun displayGoal(goal: Goal)
    }

    interface Presenter : BasePresenter<View> {
        fun getGoalForId(goalId: String)
    }
}