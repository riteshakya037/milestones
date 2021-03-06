package com.riteshakya.milestones.di.modules

import android.app.Application
import android.content.Context
import com.riteshakya.milestones.data.remote.goals.GoalManager
import com.riteshakya.milestones.data.remote.goals.GoalManagerImpl
import com.riteshakya.milestones.data.remote.session.SessionManager
import com.riteshakya.milestones.data.remote.session.SessionManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return this.application
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return application
    }


    @Provides
    @Singleton
    internal fun provideSessionManager(sessionManager: SessionManagerImpl): SessionManager {
        return sessionManager
    }

    @Provides
    @Singleton
    internal fun provideGoalManager(goalManager: GoalManagerImpl): GoalManager {
        return goalManager
    }
}
