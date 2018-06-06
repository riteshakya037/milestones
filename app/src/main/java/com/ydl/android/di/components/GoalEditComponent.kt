package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.GoalEditModule
import com.ydl.android.views.screens.goals.edit.GoalEditFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalEditModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalEditComponent {
    fun inject(goalEditFragment: GoalEditFragment)
}