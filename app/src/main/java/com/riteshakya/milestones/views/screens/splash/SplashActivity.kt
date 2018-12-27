package com.riteshakya.milestones.views.screens.splash

import android.os.Bundle
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter

class SplashActivity : BaseActivity() {
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        addFragment(navigator.getSplashFragment(this))
    }

}
