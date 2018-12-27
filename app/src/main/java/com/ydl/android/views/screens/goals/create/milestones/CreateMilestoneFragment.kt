package com.ydl.android.views.screens.goals.create.milestones

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.data.remote.goals.Milestone
import com.ydl.android.di.components.DaggerGoalComponent
import com.ydl.android.di.components.GoalComponent
import com.ydl.android.di.modules.GoalModule
import com.ydl.android.utils.addValidity
import com.ydl.android.utils.validation.types.NonEmptyValidation
import com.ydl.android.views.screens.goals.create.GoalActivity
import kotlinx.android.synthetic.main.fragment_create_milestones.*
import javax.inject.Inject

class CreateMilestoneFragment : BaseFragment<GoalComponent>(), CreateMilestoneContract.View {

    @Inject
    lateinit var presenter: CreateMilestoneContract.Presenter

    override fun getLayout(): Int {
        return R.layout.fragment_create_milestones
    }

    override fun injectFragment(component: GoalComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        addValidationList(createMilestonesOneTxt.addValidity(NonEmptyValidation()))
        addValidationList(createMilestonesTwoTxt.addValidity(NonEmptyValidation()))
        addValidationList(createMilestonesThreeTxt.addValidity(NonEmptyValidation()))
        addValidationList(createMilestonesOneDate.addValidity(NonEmptyValidation()))
        addValidationList(createMilestonesTwoDate.addValidity(NonEmptyValidation()))
        addValidationList(createMilestonesThreeDate.addValidity(NonEmptyValidation()))
        createMilestonesBtn.setOnClickListener {
            val milestones = ArrayList<Milestone>()
            milestones.add(Milestone(createMilestonesOneTxt.text, createMilestonesOneDate.text))
            milestones.add(Milestone(createMilestonesTwoTxt.text, createMilestonesTwoDate.text))
            milestones.add(Milestone(createMilestonesThreeTxt.text, createMilestonesThreeDate.text))
            presenter.createGoal(getGoalTitle(), getGoalPurpose(), milestones)
        }
    }

    private fun getGoalPurpose(): String {
        return if (arguments != null && arguments!!.containsKey(ARGS_GOAL_PURPOSE)) {
            arguments!!.getString(ARGS_GOAL_PURPOSE)
        } else ""
    }

    private fun getGoalTitle(): String {
        return if (arguments != null && arguments!!.containsKey(ARGS_GOAL_TITLE)) {
            arguments!!.getString(ARGS_GOAL_TITLE)
        } else ""
    }

    override fun setValidity(result: Boolean) {
        createMilestonesBtn.isEnabled = result
    }

    override fun initInjector(): GoalComponent {
        return DaggerGoalComponent.builder()
                .applicationComponent(applicationComponent)
                .goalModule(GoalModule(activity as GoalActivity))
                .build()
    }

    override fun showInAppError(message: String) {
        showInAppError("Goal Creation Error", message)
    }

    companion object {
        private const val ARGS_GOAL_TITLE: String = "args:goal_title"
        private const val ARGS_GOAL_PURPOSE: String = "args:goal_purpose"

        @JvmStatic
        fun newInstance(goalTitle: String, goalPurpose: String): Fragment {
            val createMilestonesFragment: Fragment = CreateMilestoneFragment()
            val bundle = Bundle()
            bundle.putString(ARGS_GOAL_TITLE, goalTitle)
            bundle.putString(ARGS_GOAL_PURPOSE, goalPurpose)
            createMilestonesFragment.arguments = bundle
            return createMilestonesFragment
        }
    }
}