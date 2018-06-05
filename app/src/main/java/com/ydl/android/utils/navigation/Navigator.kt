package com.ydl.android.utils.navigation

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import com.ydl.android.views.screens.create.GoalActivity
import com.ydl.android.views.screens.create.confirmation.GoalConfirmationFragment
import com.ydl.android.views.screens.create.goal.CreateGoalFragment
import com.ydl.android.views.screens.create.milestones.CreateMilestoneFragment
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
    fun navigateToLandingScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Intro Screen")
        context.startActivity(Intent(context, LandingActivity::class.java))
    }

    fun navigateToMainScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Main Screen")
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToCreateGoal(context: Context) {
        Timber.tag(_tag).i("Navigate to Create Goal")
        context.startActivity(Intent(context, GoalActivity::class.java))
    }

    fun getSplashFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Splash Fragment to ${context::class.java.simpleName}")
        return SplashFragment.newInstance()
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

    fun getCreateGoalFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Create Goal Fragment to ${context::class.java.simpleName}")
        return CreateGoalFragment.newInstance()
    }

    fun getCreateMilestoneFragment(context: Context, goalTitle: String, goalPurpose: String): Fragment {
        Timber.tag(_tag).i("Attached: Create Milestones Fragment to ${context::class.java.simpleName}")
        return CreateMilestoneFragment.newInstance(goalTitle, goalPurpose)
    }

    fun getGoalConfirmationFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Goal Confirmation Fragment to ${context::class.java.simpleName}")
        return GoalConfirmationFragment.newInstance()
    }

}