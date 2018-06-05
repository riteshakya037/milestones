package com.ydl.android.di.modules

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.main.MainContract
import com.ydl.android.views.screens.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val activity: AppCompatActivity) {

    @Provides
    @PerFragment
    fun providePresenter(presenter: MainPresenterImpl): MainContract.Presenter {
        return presenter
    }

    @Provides
    internal fun providesFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }
}