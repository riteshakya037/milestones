package com.riteshakya.milestones.views.screens.landing.forgotpass


import android.widget.Toast
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerForgotPasswordComponent
import com.riteshakya.milestones.di.components.ForgotPasswordComponent
import com.riteshakya.milestones.di.modules.ForgotPasswordModule
import com.riteshakya.milestones.utils.addValidity
import com.riteshakya.milestones.utils.validation.types.EmailValidation
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import javax.inject.Inject

class ForgotPasswordFragment : BaseFragment<ForgotPasswordComponent>(), ForgotPasswordContract.View {

    @Inject
    lateinit var presenter: ForgotPasswordContract.Presenter

    override fun getLayout() = R.layout.fragment_forgot_password

    override fun injectFragment(component: ForgotPasswordComponent) {
        component.inject(this)
    }

    override fun initInjector(): ForgotPasswordComponent {
        return DaggerForgotPasswordComponent.builder()
                .applicationComponent(activity().getApp().appComponent)
                .forgotPasswordModule(ForgotPasswordModule())
                .build()
    }

    override fun onResume() {
        super.onResume()
        dismissAllExceptEditText()
    }

    override fun initViews() {
        addPresenter(presenter, this)
        addValidationList(forgotPasswordEmail.addValidity(EmailValidation("Invalid Email")))
        forgotPasswordReset.setOnClickListener {
            presenter.resetPassword(forgotPasswordEmail.text)
        }
    }

    override fun setValidity(result: Boolean) {
        forgotPasswordReset.isEnabled = result
    }

    override fun onResetPasswordSuccess() {
        Toast.makeText(activity, "Email sent successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onResetPasswordFailed(throwable: Throwable) {
        showInAppError(throwable.message!!)
    }

    override fun showInAppError(message: String) {
        super.showInAppError("Reset Password Failed", message)
    }

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }
}
