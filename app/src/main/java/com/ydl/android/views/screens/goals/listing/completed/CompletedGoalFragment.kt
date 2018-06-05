package com.ydl.android.views.screens.goals.listing.completed

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.di.components.DaggerGoalListComponent
import com.ydl.android.di.components.GoalListComponent
import com.ydl.android.di.modules.GoalListModule
import com.ydl.android.views.adapters.CompletedGoalsAdapter
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