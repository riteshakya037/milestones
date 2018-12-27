package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.GoalModule
import com.riteshakya.milestones.views.screens.goals.create.confirmation.GoalConfirmationFragment
import com.riteshakya.milestones.views.screens.goals.create.goal.CreateGoalFragment
import com.riteshakya.milestones.views.screens.goals.create.milestones.CreateMilestoneFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalComponent {

    fun inject(fragment: CreateGoalFragment)

    fun inject(fragment: CreateMilestoneFragment)

    fun inject(goalConfirmationFragment: GoalConfirmationFragment)

}