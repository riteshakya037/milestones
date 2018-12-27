package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.GoalDetailModule
import com.riteshakya.milestones.views.screens.goals.details.GoalDetailFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalDetailModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalDetailComponent {
    fun inject(goalDetailFragment: GoalDetailFragment)
}