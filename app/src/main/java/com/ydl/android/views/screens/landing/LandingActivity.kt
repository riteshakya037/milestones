package com.ydl.android.views.screens.landing

import android.os.Bundle
import com.ydl.android.R
import com.ydl.android.base.BaseActivity
import com.ydl.android.base.BasePresenter
import com.ydl.android.views.adapters.LandingFragmentAdapter
import kotlinx.android.synthetic.main.activity_landing.*
import javax.inject.Inject


class LandingActivity : BaseActivity() {

    @Inject
    lateinit var landingFragmentAdapter: LandingFragmentAdapter

    override val contextView = R.layout.activity_landing


    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        initInjector().inject(this)
        landingViewPager.adapter = landingFragmentAdapter
        landingViewPager.offscreenPageLimit = 2
        landingFragmentAdapter.addFragment(navigator.getSignUpFragment(this), "Sign Up")
        landingFragmentAdapter.addFragment(navigator.getLoginFragment(this), "Log In")
        landingFragmentAdapter.addFragment(navigator.getResetPasswordFragment(this), "Reset Password")
        landingTabLayout.setupWithViewPager(landingViewPager)
    }

}
