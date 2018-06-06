package com.ydl.android.views.screens.setting

import android.os.Bundle
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter

class SettingActivity : BaseActivity() {
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addFragment(navigator.getSettingFragment(this))
        }
    }

}