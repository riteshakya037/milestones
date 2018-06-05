package com.ydl.android.di.components

import com.ydl.android.views.screens.landing.register.RegisterFragment
import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.RegisterModule
import dagger.Component

@PerFragment
@Component(modules = [(RegisterModule::class)], dependencies = [(ApplicationComponent::class)])
interface RegisterComponent {

    fun inject(fragment: RegisterFragment)

}