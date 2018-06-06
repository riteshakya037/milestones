package com.ydl.android.views.screens.setting

import com.ydl.android.base.BaseRxPresenter
import com.ydl.android.data.remote.session.SessionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SettingPresenterImpl
@Inject constructor(
        private val sessionManager: SessionManager
) : BaseRxPresenter(), SettingContract.Presenter {

    private lateinit var view: SettingContract.View

    override fun setView(view: SettingContract.View) {
        this.view = view
    }


    override fun onCreate() {
        manage(sessionManager.getUserDetails()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setEmail(it)
                }, { throwable ->
                    view.showInAppError(throwable.message!!)
                }))
    }

    override fun changePassword(email: String, password: String) {
        view.showProgressDialog()
        manage(sessionManager.changePassword(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.hideProgressDialog()
                    view.closeScreen()
                }, { throwable ->
                    view.showInAppError(throwable.message!!)
                }))
    }


}