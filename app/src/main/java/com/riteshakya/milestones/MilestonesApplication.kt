package com.riteshakya.milestones

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.riteshakya.milestones.di.components.ApplicationComponent
import com.riteshakya.milestones.di.components.DaggerApplicationComponent
import com.riteshakya.milestones.di.modules.ApplicationModule
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
        FirebaseApp.initializeApp(this)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

    private fun initializeLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // Plant necessary trees
        }
    }

}
