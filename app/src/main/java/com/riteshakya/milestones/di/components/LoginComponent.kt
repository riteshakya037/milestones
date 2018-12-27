package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.LoginModule
import com.riteshakya.milestones.views.screens.landing.login.LoginFragment
import dagger.Component

@PerFragment
@Component(modules = [(LoginModule::class)], dependencies = [(ApplicationComponent::class)])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

}