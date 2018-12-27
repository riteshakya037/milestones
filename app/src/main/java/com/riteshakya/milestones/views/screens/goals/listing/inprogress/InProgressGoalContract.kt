package com.riteshakya.milestones.views.screens.goals.listing.inprogress

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView
import com.riteshakya.milestones.data.remote.goals.Goal


interface InProgressGoalContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun addGoal(it: Goal)

    }

    interface Presenter : BasePresenter<View>
}