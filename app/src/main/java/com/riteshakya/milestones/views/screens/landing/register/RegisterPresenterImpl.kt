package com.riteshakya.milestones.views.screens.landing.register

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.session.SessionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RegisterPresenterImpl
@Inject constructor(
        private val sessionManager: SessionManager
) : BaseRxPresenter(), RegisterContract.Presenter {

    private lateinit var registerView: RegisterContract.View

    override fun setView(view: RegisterContract.View) {
        registerView = view
    }

    override fun register(email: String, password: String) {
        registerView.showProgressDialog()
        manage(sessionManager.register(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    registerView.hideProgressDialog()
                    registerView.onRegisterSuccess()
                }, { throwable -> registerView.onRegisterFailed(throwable) })
        )
    }

}