package com.ydl.android.views.screens.create

import android.os.Bundle
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter

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
