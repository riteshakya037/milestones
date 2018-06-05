package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.splash.SplashContract
import com.ydl.android.views.screens.splash.SplashPresenterImpl
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