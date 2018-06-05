package com.ydl.android.di.modules

import android.app.Application
import android.content.Context
import com.ydl.android.data.remote.session.SessionManager
import com.ydl.android.data.remote.session.SessionManagerImpl
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
}
