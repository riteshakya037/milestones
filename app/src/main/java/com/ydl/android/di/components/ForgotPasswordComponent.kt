package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.ForgotPasswordModule
import com.ydl.android.views.screens.landing.forgotpass.ForgotPasswordFragment
import dagger.Component

@PerFragment
@Component(modules = [(ForgotPasswordModule::class)], dependencies = [(ApplicationComponent::class)])
interface ForgotPasswordComponent {

    fun inject(fragment: ForgotPasswordFragment)

}