package com.ydl.android.views.screens.main

import android.os.Bundle
import com.ydl.android.R
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.GoalManager
import com.ydl.android.data.remote.goals.Mode
import com.ydl.android.utils.getCompletedCount
import com.ydl.android.views.adapters.GenericFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var goalManager: GoalManager
    @Inject
    lateinit var genericFragmentAdapter: GenericFragmentAdapter
    override val contextView = R.layout.activity_main

    private val mList = ArrayList<Goal>()
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        initInjector().inject(this)
        goalManager.getGoalsIds().doOnNext({
            if (it.isEmpty()) {
                navigator.navigateToCreateGoal(this@MainActivity)
            }
        }).subscribe()
        mainScreenViewPager.adapter = genericFragmentAdapter
        mainScreenViewPager.offscreenPageLimit = 2
        genericFragmentAdapter.addFragment(navigator.getInProgressGoalsFragment(this), "In Progress")
        genericFragmentAdapter.addFragment(navigator.getCompletedGoalsFragment(this), "Crushed")
        mainScreenTabLayout.setupWithViewPager(mainScreenViewPager)
        goalManager.getGoals(Mode.ALL).doOnNext({
            mList.add(it)
            currentGoalTxt.text = "${mList.getCompletedCount()}"
            totalGoalTxt.text = "/${mList.size}"
        }).subscribe()
    }
}
