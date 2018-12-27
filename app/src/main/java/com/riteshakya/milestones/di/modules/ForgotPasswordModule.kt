package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.landing.forgotpass.ForgotPasswordContract
import com.riteshakya.milestones.views.screens.landing.forgotpass.ForgotPasswordPresenterImpl
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