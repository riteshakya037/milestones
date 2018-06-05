package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.goals.listing.completed.CompletedGoalContract
import com.ydl.android.views.screens.goals.listing.completed.CompletedGoalPresenterImpl
import com.ydl.android.views.screens.goals.listing.inprogress.InProgressGoalContract
import com.ydl.android.views.screens.goals.listing.inprogress.InProgressGoalPresenterImpl
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