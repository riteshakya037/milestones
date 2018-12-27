package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.views.screens.landing.register.RegisterFragment
import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.RegisterModule
import dagger.Component

@PerFragment
@Component(modules = [(RegisterModule::class)], dependencies = [(ApplicationComponent::class)])
interface RegisterComponent {

    fun inject(fragment: RegisterFragment)

}