package com.riteshakya.milestones.views.screens.landing.login

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.session.SessionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class LoginPresenterImpl
@Inject constructor(
        private val sessionManager: SessionManager
) : BaseRxPresenter(), LoginContract.Presenter {

    private lateinit var loginView: LoginContract.View

    override fun setView(view: LoginContract.View) {
        loginView = view
    }

    override fun login(email: String, password: String) {
        loginView.showProgressDialog()
        manage(sessionManager.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loginView.onLoginSuccess()
                    loginView.onLoginSuccess()
                }, { throwable -> loginView.onLoginFailed(throwable) })
        )
    }

}