package com.ydl.android.di.components

import com.ydl.android.di.PerFragment
import com.ydl.android.di.modules.MainModule
import com.ydl.android.views.screens.main.MainFragment
import dagger.Component


@PerFragment
@Component(modules = [(MainModule::class)], dependencies = [(ApplicationComponent::class)])
interface MainComponent {

    fun inject(fragment: MainFragment)

}