package com.ysl.milestones.di.components

import android.app.Application
import android.content.Context
import com.ysl.milestones.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun application(): Application

    fun context(): Context

}
