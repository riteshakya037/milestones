package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.landing.register.RegisterContract
import com.ydl.android.views.screens.landing.register.RegisterPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: RegisterPresenterImpl): RegisterContract.Presenter {
        return presenter
    }

}