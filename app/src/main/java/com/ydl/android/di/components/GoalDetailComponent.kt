package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.GoalDetailModule
import com.ydl.android.views.screens.goals.details.GoalDetailFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalDetailModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalDetailComponent {
    fun inject(goalDetailFragment: GoalDetailFragment)
}