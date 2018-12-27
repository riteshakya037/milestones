package com.riteshakya.milestones.views.screens.landing.login

import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerLoginComponent
import com.riteshakya.milestones.di.components.LoginComponent
import com.riteshakya.milestones.di.modules.LoginModule
import com.riteshakya.milestones.utils.addValidity
import com.riteshakya.milestones.utils.validation.types.EmailValidation
import com.riteshakya.milestones.utils.validation.types.PasswordValidation
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject


class LoginFragment : BaseFragment<LoginComponent>(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun getLayout(): Int {
        return R.layout.fragment_login
    }

    override fun initInjector(): LoginComponent {
        return DaggerLoginComponent.builder()
                .applicationComponent(activity().getApp().appComponent)
                .loginModule(LoginModule())
                .build()
    }

    override fun injectFragment(component: LoginComponent) {
        component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        dismissAllExceptEditText()
    }

    override fun initViews() {
        addPresenter(presenter, this)
        addValidationList(loginEmail.addValidity(EmailValidation("Invalid Email")))
        addValidationList(loginPassword.addValidity(PasswordValidation("Invalid Password")))
        loginBtn.setOnClickListener {
            presenter.login(loginEmail.text.toString(), loginPassword.text.toString())
        }
    }

    override fun setValidity(result: Boolean) {
        loginBtn.isEnabled = result
    }

    override fun onLoginSuccess() {
        navigator.navigateToMainScreen(context!!)
        activity!!.finish()
    }

    override fun onLoginFailed(throwable: Throwable) {
        showInAppError(throwable.message!!)
    }

    override fun showInAppError(message: String) {
        super.showInAppError("Sign-In Failed", message)
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}
