package com.ydl.android.views.screens.goals.create.goal

import android.support.v4.app.Fragment
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerGoalComponent
import com.ydl.android.di.components.GoalComponent
import com.ydl.android.di.modules.GoalModule
import com.ydl.android.utils.addValidity
import com.ydl.android.utils.validation.types.NonEmptyValidation
import com.ydl.android.views.screens.goals.create.GoalActivity
import com.ydl.android.views.screens.goals.create.GoalFlowPresenter
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