package com.riteshakya.milestones.di.components

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.di.modules.SettingModule
import com.riteshakya.milestones.views.screens.setting.SettingFragment
import dagger.Component


@PerFragment
@Component(modules = [(SettingModule::class)], dependencies = [(ApplicationComponent::class)])
interface SettingComponent {
    fun inject(fragment: SettingFragment)
}