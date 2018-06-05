package com.ydl.android.views.screens.goals.create.milestones

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView
import com.ydl.android.data.remote.goals.Milestone


interface CreateMilestoneContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View> {
        fun createGoal(goal: String, purpose: String, milestones: List<Milestone>)
    }
}