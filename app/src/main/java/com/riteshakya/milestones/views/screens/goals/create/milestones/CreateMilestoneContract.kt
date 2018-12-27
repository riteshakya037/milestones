package com.riteshakya.milestones.views.screens.goals.create.milestones

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView
import com.riteshakya.milestones.data.remote.goals.Milestone


interface CreateMilestoneContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View> {
        fun createGoal(goal: String, purpose: String, milestones: List<Milestone>)
    }
}