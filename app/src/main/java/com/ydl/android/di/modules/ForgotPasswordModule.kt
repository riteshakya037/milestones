package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.landing.forgotpass.ForgotPasswordContract
import com.ydl.android.views.screens.landing.forgotpass.ForgotPasswordPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class ForgotPasswordModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: ForgotPasswordPresenterImpl): ForgotPasswordContract.Presenter {
        return presenter
    }
}