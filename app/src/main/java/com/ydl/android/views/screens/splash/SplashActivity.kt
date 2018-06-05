package com.ydl.android.views.screens.splash

import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter

class SplashActivity : BaseActivity() {
    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        addFragment(navigator.getSplashFragment(this))
    }

}
