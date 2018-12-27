package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.goals.edit.GoalEditContract
import com.riteshakya.milestones.views.screens.goals.edit.GoalEditPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class GoalEditModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: GoalEditPresenterImpl): GoalEditContract.Presenter {
        return presenter
    }
}