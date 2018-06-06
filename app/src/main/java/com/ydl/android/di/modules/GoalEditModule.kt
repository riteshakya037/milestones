package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.goals.edit.GoalEditContract
import com.ydl.android.views.screens.goals.edit.GoalEditPresenterImpl
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