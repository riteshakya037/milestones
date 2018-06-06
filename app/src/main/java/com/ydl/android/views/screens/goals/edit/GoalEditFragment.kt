package com.ydl.android.views.screens.goals.edit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.data.exceptions.GoalNotFoundException
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.di.components.DaggerGoalEditComponent
import com.ydl.android.di.components.GoalEditComponent
import com.ydl.android.di.modules.GoalEditModule
import com.ydl.android.utils.addValidity
import com.ydl.android.utils.validation.types.NonEmptyValidation
import kotlinx.android.synthetic.main.fragment_goal_edit.*
import javax.inject.Inject

class GoalEditFragment : BaseFragment<GoalEditComponent>(), GoalEditContract.View {
    override fun displayGoal(goal: Goal) {
        goalTitle.text = goal.title
        goalPurpose.text = goal.purpose
        milestoneOne.text = goal.milestones[0].title
        milestoneTwo.text = goal.milestones[1].title
        milestoneThree.text = goal.milestones[2].title
        milestoneOneDate.text = goal.milestones[0].dueDate
        milestoneTwoDate.text = goal.milestones[1].dueDate
        milestoneThreeDate.text = goal.milestones[2].dueDate
    }

    @Inject
    lateinit var presenter: GoalEditContract.Presenter

    override fun getLayout(): Int {
        return R.layout.fragment_goal_edit
    }

    override fun injectFragment(component: GoalEditComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        presenter.getGoalForId(getGoalId())
        addValidationList(goalTitle.addValidity(NonEmptyValidation()))
        addValidationList(goalPurpose.addValidity(NonEmptyValidation()))
        addValidationList(milestoneOne.addValidity(NonEmptyValidation()))
        addValidationList(milestoneTwo.addValidity(NonEmptyValidation()))
        addValidationList(milestoneThree.addValidity(NonEmptyValidation()))
        addValidationList(milestoneOneDate.addValidity(NonEmptyValidation()))
        addValidationList(milestoneTwoDate.addValidity(NonEmptyValidation()))
        addValidationList(milestoneThreeDate.addValidity(NonEmptyValidation()))

        navigateBackBtn.setOnClickListener { activity?.finish() }
        saveGoalBtn.setOnClickListener { }
    }

    override fun setValidity(result: Boolean) {
        saveGoalBtn.visibility = if (result) VISIBLE else GONE
    }

    override fun initInjector(): GoalEditComponent {
        return DaggerGoalEditComponent.builder()
                .applicationComponent(applicationComponent)
                .goalEditModule(GoalEditModule())
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
            val fragment = GoalEditFragment()
            val bundle = Bundle()
            bundle.putString(ARGS_GOAL_ID, goalId)
            fragment.arguments = bundle
            return fragment
        }
    }
}