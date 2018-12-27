package com.riteshakya.milestones.views.screens.goals.create.goal

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView


interface CreateGoalContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View>
}