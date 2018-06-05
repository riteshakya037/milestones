package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.GoalModule
import com.ydl.android.views.screens.create.confirmation.GoalConfirmationFragment
import com.ydl.android.views.screens.create.goal.CreateGoalFragment
import com.ydl.android.views.screens.create.milestones.CreateMilestoneFragment
import dagger.Component


@PerFragment
@Component(modules = [(GoalModule::class)], dependencies = [(ApplicationComponent::class)])
interface GoalComponent {

    fun inject(fragment: CreateGoalFragment)

    fun inject(fragment: CreateMilestoneFragment)

    fun inject(goalConfirmationFragment: GoalConfirmationFragment)

}