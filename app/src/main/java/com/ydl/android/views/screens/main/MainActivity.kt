package com.ydl.android.views.screens.main

import android.os.Bundle
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter
import com.ydl.android.data.remote.goals.GoalManager
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var goalManager: GoalManager

    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        initInjector().inject(this)
        goalManager.getGoalsIds().doOnNext({
            if (it.isEmpty()) {
                navigator.navigateToCreateGoal(this@MainActivity)
            }
        }).subscribe()
    }
}
