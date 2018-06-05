package com.ydl.android.di.components

import android.app.Application
import android.content.Context
import com.ydl.android.data.remote.goals.GoalManager
import com.ydl.android.data.remote.session.SessionManager
import com.ydl.android.di.modules.ApplicationModule
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
