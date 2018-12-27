package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.GoalListModule
import com.riteshakya.milestones.views.screens.goals.listing.completed.CompletedGoalFragment
import com.riteshakya.milestones.views.screens.goals.listing.inprogress.InProgressGoalFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalListModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalListComponent {
    fun inject(completedGoalFragment: CompletedGoalFragment)

    fun inject(inProgressGoalFragment: InProgressGoalFragment)

}