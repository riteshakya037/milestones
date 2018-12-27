package com.ydl.android.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
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