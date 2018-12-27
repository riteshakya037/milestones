package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.landing.login.LoginContract
import com.riteshakya.milestones.views.screens.landing.login.LoginPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: LoginPresenterImpl): LoginContract.Presenter {
        return presenter
    }
}