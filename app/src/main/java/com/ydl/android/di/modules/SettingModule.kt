package com.ydl.android.di.modules

import com.ydl.android.di.PerFragment
import com.ydl.android.views.screens.setting.SettingContract
import com.ydl.android.views.screens.setting.SettingPresenterImpl
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