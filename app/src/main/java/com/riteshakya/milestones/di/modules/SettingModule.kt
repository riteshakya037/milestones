package com.riteshakya.milestones.di.modules

import com.riteshakya.milestones.di.PerFragment
import com.riteshakya.milestones.views.screens.setting.SettingContract
import com.riteshakya.milestones.views.screens.setting.SettingPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class SettingModule {

    @Provides
    @PerFragment
    fun providePresenter(presenter: SettingPresenterImpl): SettingContract.Presenter {
        return presenter
    }
}