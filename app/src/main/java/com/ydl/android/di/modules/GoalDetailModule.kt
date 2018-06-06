package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.goals.details.GoalDetailPresenterImpl
import com.ydl.android.views.screens.goals.details.GoalDetailsContract
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