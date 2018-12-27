package com.riteshakya.milestones.views.screens.landing

import android.os.Bundle
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseActivity
import com.riteshakya.milestones.base.BasePresenter
import com.riteshakya.milestones.views.adapters.GenericFragmentAdapter
import kotlinx.android.synthetic.main.activity_landing.*
import javax.inject.Inject


class LandingActivity : BaseActivity() {

    @Inject
    lateinit var genericFragmentAdapter: GenericFragmentAdapter

    override val contextView = R.layout.activity_landing


    override val presenter: BasePresenter<*>?
        get() = null

    override fun initActivity(savedInstanceState: Bundle?) {
        initInjector().inject(this)
        landingViewPager.adapter = genericFragmentAdapter
        landingViewPager.offscreenPageLimit = 2
        genericFragmentAdapter.addFragment(navigator.getSignUpFragment(this), "Sign Up")
        genericFragmentAdapter.addFragment(navigator.getLoginFragment(this), "Log In")
        genericFragmentAdapter.addFragment(navigator.getResetPasswordFragment(this), "Reset Password")
        landingTabLayout.setupWithViewPager(landingViewPager)
    }

}
