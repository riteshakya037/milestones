package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.GoalListModule
import com.ydl.android.views.screens.goals.listing.completed.CompletedGoalFragment
import com.ydl.android.views.screens.goals.listing.inprogress.InProgressGoalFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalListModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalListComponent {
    fun inject(completedGoalFragment: CompletedGoalFragment)

    fun inject(inProgressGoalFragment: InProgressGoalFragment)

}