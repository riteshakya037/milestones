package com.riteshakya.milestones.views.screens.goals.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.data.exceptions.GoalNotFoundException

class GoalDetailActivity : BaseActivity() {
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addFragment(navigator.getGoalDetailFragment(this, getGoalId()))
        }
    }

    private fun getGoalId(): String {
        return if (intent != null && intent.hasExtra(ARGS_GOAL_ID))
            intent.getStringExtra(ARGS_GOAL_ID)
        else throw GoalNotFoundException()
    }

    companion object {

        private const val ARGS_GOAL_ID: String = "args:goal_id"

        @JvmStatic
        fun newInstance(context: Context, goalId: String): Intent {
            val intent = Intent(context, GoalDetailActivity::class.java)
            intent.putExtra(ARGS_GOAL_ID, goalId)
            return intent
        }
    }

}