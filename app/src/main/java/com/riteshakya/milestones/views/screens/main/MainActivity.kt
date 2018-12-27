package com.riteshakya.milestones.views.screens.main

import android.os.Bundle
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter

class MainActivity : BaseActivity() {

    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            addFragment(navigator.getMainFragment(this))
    }
}
