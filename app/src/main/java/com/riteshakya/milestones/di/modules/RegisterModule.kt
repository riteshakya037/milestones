package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.landing.register.RegisterContract
import com.riteshakya.milestones.views.screens.landing.register.RegisterPresenterImpl
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