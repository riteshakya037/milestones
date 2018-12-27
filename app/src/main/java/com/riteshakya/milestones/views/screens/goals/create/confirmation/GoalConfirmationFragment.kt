package com.riteshakya.milestones.views.screens.goals.create.confirmation

import androidx.fragment.app.Fragment
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerGoalComponent
import com.riteshakya.milestones.di.components.GoalComponent
import com.riteshakya.milestones.di.modules.GoalModule
import com.riteshakya.milestones.views.screens.goals.create.GoalActivity
import kotlinx.android.synthetic.main.fragment_goal_confirmation.*

class GoalConfirmationFragment : BaseFragment<GoalComponent>() {
    override fun getLayout(): Int {
        return R.layout.fragment_goal_confirmation
    }

    override fun injectFragment(component: GoalComponent) {
        component.inject(this)
    }

    override fun initViews() {
        confirmationBtn.setOnClickListener {
            navigator.navigateToMainScreen(activity!!)
            activity!!.finish()
        }
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
            return GoalConfirmationFragment()
        }
    }
}
