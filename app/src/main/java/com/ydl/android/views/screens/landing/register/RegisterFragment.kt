package com.ydl.android.views.screens.landing.register

import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerRegisterComponent
import com.ydl.android.di.components.RegisterComponent
import com.ydl.android.di.modules.RegisterModule
import com.ydl.android.utils.addValidity
import com.ydl.android.utils.validation.types.EmailValidation
import com.ydl.android.utils.validation.types.PasswordValidation
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

class RegisterFragment : BaseFragment<RegisterComponent>(), RegisterContract.View {


    @Inject
    lateinit var mPresenter: RegisterContract.Presenter

    override fun getLayout(): Int {
        return R.layout.fragment_register
    }

    override fun initInjector(): RegisterComponent {
        return DaggerRegisterComponent.builder()
                .applicationComponent(activity().getApp().appComponent)
                .registerModule(RegisterModule())
                .build()
    }

    override fun injectFragment(component: RegisterComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(mPresenter, this)
        addValidationList(registerEmail.addValidity(EmailValidation("Invalid Email")))
        addValidationList(registerPassword.addValidity(PasswordValidation("Invalid Password")))
        registerBtn.setOnClickListener {
            registerUser()
        }
    }

    override fun setValidity(result: Boolean) {
        registerBtn.isEnabled = result
    }

    override fun onResume() {
        super.onResume()
        dismissAllExceptEditText()
    }

    private fun registerUser() {
        val email: String = registerEmail.text.toString()
        val password: String = registerPassword.text.toString()
        mPresenter.register(email, password)
    }

    override fun onRegisterSuccess() {
        navigator.navigateToMainScreen(activity())
        activity().finishAffinity()
    }

    override fun onRegisterFailed(throwable: Throwable) {
        showInAppError(throwable.message!!)
    }


    override fun showInAppError(message: String) {
        super.showInAppError("Register Failed", message)
    }


    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}
