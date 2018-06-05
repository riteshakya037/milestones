package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.LoginModule
import com.ydl.android.views.screens.landing.login.LoginFragment
import dagger.Component

@PerFragment
@Component(modules = [(LoginModule::class)], dependencies = [(ApplicationComponent::class)])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

}