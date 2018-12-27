package com.riteshakya.milestones.views.screens.goals.listing.completed

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.data.remote.goals.Goal
import com.riteshakya.milestones.di.components.DaggerGoalListComponent
import com.riteshakya.milestones.di.components.GoalListComponent
import com.riteshakya.milestones.di.modules.GoalListModule
import com.riteshakya.milestones.views.adapters.CompletedGoalsAdapter
import kotlinx.android.synthetic.main.fragment_completed_goals.*
import javax.inject.Inject

class CompletedGoalFragment : BaseFragment<GoalListComponent>(), CompletedGoalContract.View {

    @Inject
    lateinit var presenter: CompletedGoalContract.Presenter

    @Inject
    lateinit var adapter: CompletedGoalsAdapter

    override fun getLayout(): Int {
        return R.layout.fragment_completed_goals
    }

    override fun injectFragment(component: GoalListComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        completedList.adapter = adapter
        completedList.layoutManager = LinearLayoutManager(context)
    }

    override fun addGoal(goal: Goal) {
        adapter.addGoal(goal)
    }

    override fun initInjector(): GoalListComponent {
        return DaggerGoalListComponent.builder()
                .applicationComponent(applicationComponent)
                .goalListModule(GoalListModule())
                .build()
    }

    override fun showInAppError(message: String) {
        showInAppError("Error fetching goals", message)
    }

    companion object {

        @JvmStatic
        fun newInstance(): Fragment {
            return CompletedGoalFragment()
        }
    }
}