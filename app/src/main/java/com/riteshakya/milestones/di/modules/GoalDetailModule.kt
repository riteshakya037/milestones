package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.goals.details.GoalDetailPresenterImpl
import com.riteshakya.milestones.views.screens.goals.details.GoalDetailsContract
import dagger.Module
import dagger.Provides

@Module
class GoalDetailModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: GoalDetailPresenterImpl): GoalDetailsContract.Presenter {
        return presenter
    }
}