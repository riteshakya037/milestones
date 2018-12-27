package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.ForgotPasswordModule
import com.riteshakya.milestones.views.screens.landing.forgotpass.ForgotPasswordFragment
import dagger.Component

@PerFragment
@Component(modules = [(ForgotPasswordModule::class)], dependencies = [(ApplicationComponent::class)])
interface ForgotPasswordComponent {

    fun inject(fragment: ForgotPasswordFragment)

}