package com.riteshakya.milestones.views.screens.landing.forgotpass

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.session.SessionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ForgotPasswordPresenterImpl
@Inject constructor(
        private val sessionManager: SessionManager
) : BaseRxPresenter(), ForgotPasswordContract.Presenter {

    private lateinit var view: ForgotPasswordContract.View

    override fun setView(view: ForgotPasswordContract.View) {
        this.view = view
    }

    override fun resetPassword(email: String) {
        view.showProgressDialog()
        manage(sessionManager.forgotPassword(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { view.hideProgressDialog() }
                .subscribe(
                        { view.onResetPasswordSuccess() },
                        { throwable -> view.onResetPasswordFailed(throwable) }
                )
        )
    }

}