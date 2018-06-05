package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.landing.login.LoginContract
import com.ydl.android.views.screens.landing.login.LoginPresenterImpl
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