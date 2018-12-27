package com.riteshakya.milestones.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.main.MainContract
import com.riteshakya.milestones.views.screens.main.MainPresenterImpl
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