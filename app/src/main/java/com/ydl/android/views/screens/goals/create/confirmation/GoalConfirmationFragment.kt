package com.ydl.android.views.screens.goals.create.confirmation

import android.support.v4.app.Fragment
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerGoalComponent
import com.ydl.android.di.components.GoalComponent
import com.ydl.android.di.modules.GoalModule
import com.ydl.android.views.screens.goals.create.GoalActivity
import kotlinx.android.synthetic.main.fragment_goal_confirmation.*

class GoalConfirmationFragment : BaseFragment<GoalComponent>() {
    override fun getLayout(): Int {
        return R.layout.fragment_goal_confirmation
    }

    override fun injectFragment(component: GoalComponent) {
        component.inject(this)
    }

    override fun initViews() {
        confirmationBtn.setOnClickListener { navigator.navigateToMainScreen(activity!!) }
        activity!!.finish()
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
