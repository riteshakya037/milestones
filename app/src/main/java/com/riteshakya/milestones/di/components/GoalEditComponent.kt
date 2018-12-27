package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.GoalEditModule
import com.riteshakya.milestones.views.screens.goals.edit.GoalEditFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalEditModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalEditComponent {
    fun inject(goalEditFragment: GoalEditFragment)
}