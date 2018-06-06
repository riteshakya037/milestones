package com.ydl.android.views.screens.goals.listing.inprogress

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.di.components.DaggerGoalListComponent
import com.ydl.android.di.components.GoalListComponent
import com.ydl.android.di.modules.GoalListModule
import com.ydl.android.views.adapters.InProgressGoalsAdapter
import kotlinx.android.synthetic.main.fragment_in_progress_goals.*
import javax.inject.Inject

class InProgressGoalFragment : BaseFragment<GoalListComponent>(), InProgressGoalContract.View {

    @Inject
    lateinit var presenter: InProgressGoalContract.Presenter


    @Inject
    lateinit var adapter: InProgressGoalsAdapter

    override fun getLayout(): Int {
        return R.layout.fragment_in_progress_goals
    }

    override fun injectFragment(component: GoalListComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        inProgressList.adapter = adapter
        inProgressList.layoutManager = LinearLayoutManager(context)
        adapter.singleClickPublish.doOnNext {
            navigator.navigateToGoalDetail(context!!, it.id)
        }.subscribe()
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
            return InProgressGoalFragment()
        }
    }
}