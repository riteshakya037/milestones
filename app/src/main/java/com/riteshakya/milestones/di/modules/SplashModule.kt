package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.splash.SplashContract
import com.riteshakya.milestones.views.screens.splash.SplashPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: SplashPresenterImpl): SplashContract.Presenter {
        return presenter
    }
}