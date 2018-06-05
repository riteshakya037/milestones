package com.ysl.milestones.di.modules

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

import dagger.Module
import dagger.Provides

/**
 * @author Ritesh Shakya
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    internal fun activity(): AppCompatActivity {
        return this.activity
    }

    @Provides
    internal fun providesFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }
}