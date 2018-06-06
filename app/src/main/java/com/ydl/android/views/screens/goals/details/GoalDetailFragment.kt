package com.ydl.android.views.screens.goals.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.data.exceptions.GoalNotFoundException
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.di.components.DaggerGoalDetailComponent
import com.ydl.android.di.components.GoalDetailComponent
import com.ydl.android.di.modules.GoalDetailModule
import com.ydl.android.views.adapters.MilestoneDetailAdapter
import kotlinx.android.synthetic.main.fragment_goal_details.*
import javax.inject.Inject

class GoalDetailFragment : BaseFragment<GoalDetailComponent>(), GoalDetailsContract.View {
    override fun displayGoal(goal: Goal) {
        goalTitle.text = goal.title
        goalPurpose.text = goal.purpose
        adapter.setGoal(goal)
    }

    @Inject
    lateinit var presenter: GoalDetailsContract.Presenter

    @Inject
    lateinit var adapter: MilestoneDetailAdapter

    override fun getLayout(): Int {
        return R.layout.fragment_goal_details
    }

    override fun injectFragment(component: GoalDetailComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        presenter.getGoalForId(getGoalId())
        navigateBackBtn.setOnClickListener { activity?.finish() }
        editGoalBtn.setOnClickListener { navigator.navigateToEditGoal(activity!!, getGoalId()) }
        milestonesList.adapter = adapter
        milestonesList.layoutManager = LinearLayoutManager(context)
    }

    override fun initInjector(): GoalDetailComponent {
        return DaggerGoalDetailComponent.builder()
                .applicationComponent(applicationComponent)
                .goalDetailModule(GoalDetailModule())
                .build()
    }

    override fun showInAppError(message: String) {
        showInAppError("Error fetching goals", message)
    }

    private fun getGoalId(): String {
        return if (arguments != null && arguments!!.containsKey(ARGS_GOAL_ID))
            arguments!!.getString(ARGS_GOAL_ID)
        else throw GoalNotFoundException()
    }

    companion object {
        private const val ARGS_GOAL_ID: String = "args:goal_id"

        @JvmStatic
        fun newInstance(goalId: String): Fragment {
            val fragment = GoalDetailFragment()
            val bundle = Bundle()
            bundle.putString(ARGS_GOAL_ID, goalId)
            fragment.arguments = bundle
            return fragment
        }
    }
}