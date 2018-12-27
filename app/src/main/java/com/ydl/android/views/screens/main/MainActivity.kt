package com.ydl.android.views.screens.main

import android.os.Bundle
import androidx.core.view.GravityCompat
import com.ydl.android.R
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.GoalManager
import com.ydl.android.data.remote.goals.Mode
import com.ydl.android.utils.getCompletedCount
import com.ydl.android.views.adapters.GenericFragmentAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            addFragment(navigator.getMainFragment(this))
    }
}
