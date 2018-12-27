package com.riteshakya.milestones.di.components

import androidx.appcompat.app.AppCompatActivity
import com.riteshakya.milestones.di.PerActivity
import com.riteshakya.milestones.di.modules.ActivityModule
import com.riteshakya.milestones.views.screens.landing.LandingActivity
import com.riteshakya.milestones.views.screens.main.MainActivity
import dagger.Component

/**
 * @author Ritesh Shakya
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity(): AppCompatActivity

    fun inject(splashActivity: LandingActivity)

    fun inject(splashActivity: MainActivity)
}