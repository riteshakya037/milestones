package com.ysl.milestones.di.components

import android.support.v7.app.AppCompatActivity
import com.ysl.milestones.di.PerActivity
import com.ysl.milestones.di.modules.ActivityModule
import dagger.Component

/**
 * @author Ritesh Shakya
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
}