package com.ydl.android.utils.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.ydl.android.views.screens.landing.LandingActivity
import com.ydl.android.views.screens.landing.forgotpass.ForgotPasswordFragment
import com.ydl.android.views.screens.landing.login.LoginFragment
import com.ydl.android.views.screens.landing.register.RegisterFragment
import com.ydl.android.views.screens.main.MainActivity
import com.ydl.android.views.screens.splash.SplashFragment
import timber.log.Timber
import javax.inject.Inject

/**
 * author riteshakya037
 */
class Navigator @Inject constructor() {
    private val _tag: String = "Navigator"


    fun getSplashFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Splash Fragment to ${context::class.java.simpleName}")
        return SplashFragment.newInstance()
    }

    fun navigateToLandingScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Intro Screen")
        context.startActivity(Intent(context, LandingActivity::class.java))
    }

    fun navigateToMainScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Main Screen")
        context.startActivity(Intent(context, MainActivity::class.java))
    }

    fun getSignUpFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Sign Up Fragment to ${context::class.java.simpleName}")
        return RegisterFragment.newInstance()
    }

    fun getLoginFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Login Fragment to ${context::class.java.simpleName}")
        return LoginFragment.newInstance()
    }

    fun getResetPasswordFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Reset Password Fragment to ${context::class.java.simpleName}")
        return ForgotPasswordFragment.newInstance()
    }

}