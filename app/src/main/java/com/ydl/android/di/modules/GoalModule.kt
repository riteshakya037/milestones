package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.create.GoalFlowPresenter
import com.ydl.android.views.screens.create.milestones.CreateMilestoneContract
import com.ydl.android.views.screens.create.milestones.CreateMilestonePresenterImpl
import dagger.Module
import dagger.Provides

@Module
class GoalModule(val goalFlowPresenter: GoalFlowPresenter) {

    @Provides
    @PerFragment
    fun providePresenter(presenter: CreateMilestonePresenterImpl): CreateMilestoneContract.Presenter {
        return presenter
    }


    @Provides
    @PerFragment
    fun provideFlowPresenter(): GoalFlowPresenter {
        return goalFlowPresenter
    }
}