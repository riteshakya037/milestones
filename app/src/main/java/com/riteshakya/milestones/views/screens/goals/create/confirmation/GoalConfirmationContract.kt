package com.riteshakya.milestones.views.screens.goals.create.confirmation

import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.base.BaseView


interface GoalConfirmationContract {

    interface View : BaseView {

        fun showInAppError(message: String)

    }

    interface Presenter : BasePresenter<View>
}