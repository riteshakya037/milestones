package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.MainModule
import com.riteshakya.milestones.views.screens.main.MainFragment
import dagger.Component


@PerFragment
@Component(modules = [(MainModule::class)], dependencies = [(ApplicationComponent::class)])
interface MainComponent {

    fun inject(fragment: MainFragment)

}