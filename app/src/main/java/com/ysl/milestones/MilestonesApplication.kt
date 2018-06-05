package com.ysl.milestones

import android.app.Application
import com.ysl.milestones.di.components.ApplicationComponent
import com.ysl.milestones.di.components.DaggerApplicationComponent
import com.ysl.milestones.di.modules.ApplicationModule
import timber.log.Timber

class MilestonesApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.initializeLogger()
    }

    private fun initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // Plant necessary trees
        }
    }

}
