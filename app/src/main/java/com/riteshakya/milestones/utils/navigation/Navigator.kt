package com.riteshakya.milestones.utils.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.riteshakya.milestones.views.screens.goals.create.GoalActivity
import com.riteshakya.milestones.views.screens.goals.create.confirmation.GoalConfirmationFragment
import com.riteshakya.milestones.views.screens.goals.create.goal.CreateGoalFragment
import com.riteshakya.milestones.views.screens.goals.create.milestones.CreateMilestoneFragment
import com.riteshakya.milestones.views.screens.goals.details.GoalDetailActivity
import com.riteshakya.milestones.views.screens.goals.details.GoalDetailFragment
import com.riteshakya.milestones.views.screens.goals.edit.GoalEditActivity
import com.riteshakya.milestones.views.screens.goals.edit.GoalEditFragment
import com.riteshakya.milestones.views.screens.goals.listing.completed.CompletedGoalFragment
import com.riteshakya.milestones.views.screens.goals.listing.inprogress.InProgressGoalFragment
import com.riteshakya.milestones.views.screens.landing.LandingActivity
import com.riteshakya.milestones.views.screens.landing.forgotpass.ForgotPasswordFragment
import com.riteshakya.milestones.views.screens.landing.login.LoginFragment
import com.riteshakya.milestones.views.screens.landing.register.RegisterFragment
import com.riteshakya.milestones.views.screens.main.MainActivity
import com.riteshakya.milestones.views.screens.main.MainFragment
import com.riteshakya.milestones.views.screens.setting.SettingActivity
import com.riteshakya.milestones.views.screens.setting.SettingFragment
import com.riteshakya.milestones.views.screens.splash.SplashActivity
import com.riteshakya.milestones.views.screens.splash.SplashFragment
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

    fun navigateToSplashScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Splash Screen")
        context.startActivity(Intent(context, SplashActivity::class.java))
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


    fun navigateToGoalDetail(context: Context, id: String) {
        Timber.tag(_tag).i("Navigate to Goal Detail for $id")
        context.startActivity(GoalDetailActivity.newInstance(context, id))
    }


    fun navigateToEditGoal(context: Context, goalId: String) {
        Timber.tag(_tag).i("Navigate to Goal Edit for $goalId")
        context.startActivity(GoalEditActivity.newInstance(context, goalId))
    }


    fun navigateToSettingScreen(context: Context) {
        Timber.tag(_tag).i("Navigate to Settings")
        context.startActivity(Intent(context, SettingActivity::class.java))
    }

    fun getSplashFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Splash Fragment to ${context::class.java.simpleName}")
        return SplashFragment.newInstance()
    }

    fun getMainFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Main Fragment to ${context::class.java.simpleName}")
        return MainFragment.newInstance()
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

    fun getInProgressGoalsFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Goal in progress Fragment to ${context::class.java.simpleName}")
        return InProgressGoalFragment.newInstance()
    }

    fun getCompletedGoalsFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Goal completed Fragment to ${context::class.java.simpleName}")
        return CompletedGoalFragment.newInstance()
    }

    fun getGoalDetailFragment(context: Context, goalId: String): Fragment {
        Timber.tag(_tag).i("Attached: Goal detail Fragment to ${context::class.java.simpleName}")
        return GoalDetailFragment.newInstance(goalId)
    }

    fun getGoalEditFragment(context: Context, goalId: String): Fragment {
        Timber.tag(_tag).i("Attached: Goal edit Fragment to ${context::class.java.simpleName}")
        return GoalEditFragment.newInstance(goalId)
    }

    fun getSettingFragment(context: Context): Fragment {
        Timber.tag(_tag).i("Attached: Settings Fragment to ${context::class.java.simpleName}")
        return SettingFragment.newInstance()
    }

}