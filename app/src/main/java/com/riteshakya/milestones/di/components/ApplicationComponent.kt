package com.riteshakya.milestones.di.components

import android.app.Application
import android.content.Context
import com.riteshakya.milestones.data.remote.goals.GoalManager
import com.riteshakya.milestones.data.remote.session.SessionManager
import com.riteshakya.milestones.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun application(): Application

    fun context(): Context

    fun sessionManager(): SessionManager

    fun goalManager(): GoalManager
}
