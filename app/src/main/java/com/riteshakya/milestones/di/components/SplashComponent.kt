package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.SplashModule
import com.riteshakya.milestones.views.screens.splash.SplashFragment
import dagger.Component

@PerFragment
@Component(modules = [(SplashModule::class)], dependencies = [(ApplicationComponent::class)])
interface SplashComponent {
    fun inject(splashFragment: SplashFragment)
}