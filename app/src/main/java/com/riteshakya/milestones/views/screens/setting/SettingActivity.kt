package com.riteshakya.milestones.views.screens.setting

import android.os.Bundle
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter

class SettingActivity : BaseActivity() {
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addFragment(navigator.getSettingFragment(this))
        }
    }

}