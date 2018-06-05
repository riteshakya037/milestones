package com.ydl.android.di.components

import android.support.v7.app.AppCompatActivity
import com.ydl.android.di.PerActivity
import com.ydl.android.di.modules.ActivityModule
import com.ydl.android.views.screens.landing.LandingActivity
import com.ydl.android.views.screens.main.MainActivity
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