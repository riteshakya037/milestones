package com.riteshakya.milestones.views.screens.goals.create.goal

import androidx.fragment.app.Fragment
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerGoalComponent
import com.riteshakya.milestones.di.components.GoalComponent
import com.riteshakya.milestones.di.modules.GoalModule
import com.riteshakya.milestones.utils.addValidity
import com.riteshakya.milestones.utils.validation.types.NonEmptyValidation
import com.riteshakya.milestones.views.screens.goals.create.GoalActivity
import com.riteshakya.milestones.views.screens.goals.create.GoalFlowPresenter
import kotlinx.android.synthetic.main.fragment_create_goal.*
import javax.inject.Inject

class CreateGoalFragment : BaseFragment<GoalComponent>(), CreateGoalContract.View {
    override fun showInAppError(message: String) {
        showInAppError("Goal Creation Error", message)
    }

    @Inject
    lateinit var goalFlowPresenter: GoalFlowPresenter

    override fun getLayout(): Int {
        return R.layout.fragment_create_goal
    }

    override fun injectFragment(component: GoalComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addValidationList(createGoalTitleTxt.addValidity(NonEmptyValidation("Field cannot me empty")))
        addValidationList(createGoalPurposeTxt.addValidity(NonEmptyValidation("Field cannot me empty")))
        createGoalBtn.setOnClickListener {
            goalFlowPresenter.navigateToCreateMilestones(createGoalTitleTxt.text, createGoalPurposeTxt.text)
        }
    }

    override fun setValidity(result: Boolean) {
        createGoalBtn.isEnabled = result
    }

    override fun initInjector(): GoalComponent {
        return DaggerGoalComponent.builder()
                .applicationComponent(applicationComponent)
                .goalModule(GoalModule(activity as GoalActivity))
                .build()
    }


    companion object {
        @JvmStatic
        fun newInstance(): Fragment {
            return CreateGoalFragment()
        }
    }
}