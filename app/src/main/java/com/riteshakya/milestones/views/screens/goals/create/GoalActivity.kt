package com.riteshakya.milestones.views.screens.goals.create

import android.os.Bundle
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter

class GoalActivity : BaseActivity(), GoalFlowPresenter {


    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            addFragment(navigator.getCreateGoalFragment(this))
    }

    override fun navigateToCreateMilestones(goalTitle: String, goalPurpose: String) {
        addFragment(navigator.getCreateMilestoneFragment(this, goalTitle, goalPurpose))
    }

    override fun navigateToGoalConfirmation() {
        addFragment(navigator.getGoalConfirmationFragment(this))
    }
}
