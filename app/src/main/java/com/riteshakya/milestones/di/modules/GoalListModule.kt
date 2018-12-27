package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.goals.listing.completed.CompletedGoalContract
import com.riteshakya.milestones.views.screens.goals.listing.completed.CompletedGoalPresenterImpl
import com.riteshakya.milestones.views.screens.goals.listing.inprogress.InProgressGoalContract
import com.riteshakya.milestones.views.screens.goals.listing.inprogress.InProgressGoalPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class GoalListModule() {
    @Provides
    @PerFragment
    fun provideInProgressPresenter(presenter: InProgressGoalPresenterImpl): InProgressGoalContract.Presenter {
        return presenter
    }

    @Provides
    @PerFragment
    fun provideCompletedPresenter(presenter: CompletedGoalPresenterImpl): CompletedGoalContract.Presenter {
        return presenter
    }


}