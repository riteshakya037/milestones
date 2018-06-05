package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.SplashModule
import com.ydl.android.views.screens.splash.SplashFragment
import dagger.Component

@PerFragment
@Component(modules = [(SplashModule::class)], dependencies = [(ApplicationComponent::class)])
interface SplashComponent {
    fun inject(splashFragment: SplashFragment)
}