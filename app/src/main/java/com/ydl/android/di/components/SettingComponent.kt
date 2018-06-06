package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.SettingModule
import com.ydl.android.views.screens.setting.SettingFragment
import dagger.Component


@PerFragment
@Component(modules = [(SettingModule::class)], dependencies = [(ApplicationComponent::class)])
interface SettingComponent {
    fun inject(fragment: SettingFragment)
}