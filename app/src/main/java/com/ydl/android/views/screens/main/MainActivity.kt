package com.ydl.android.views.screens.main

import android.os.Bundle
import com.ydl.android.R
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter
import com.ydl.android.data.remote.goals.GoalManager
import com.ydl.android.views.adapters.GenericFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var goalManager: GoalManager
    @Inject
    lateinit var genericFragmentAdapter: GenericFragmentAdapter
    override val contextView = R.layout.activity_main

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
    }
}
