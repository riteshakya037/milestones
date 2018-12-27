package com.riteshakya.milestones.views.screens.setting

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerSettingComponent
import com.riteshakya.milestones.di.components.SettingComponent
import com.riteshakya.milestones.di.modules.SettingModule
import com.riteshakya.milestones.utils.addValidity
import com.riteshakya.milestones.utils.validation.types.EmailValidation
import com.riteshakya.milestones.utils.validation.types.PasswordValidation
import kotlinx.android.synthetic.main.fragment_setting.*
import javax.inject.Inject

class SettingFragment : BaseFragment<SettingComponent>(), SettingContract.View {

    @Inject
    lateinit var presenter: SettingContract.Presenter

    override fun getLayout(): Int {
        return R.layout.fragment_setting
    }

    override fun injectFragment(component: SettingComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        navigateBackBtn.setOnClickListener { activity?.finish() }
        addValidationList(settingEmailTxt.addValidity(EmailValidation("Invalid email")))
        addValidationList(settingPasswordTxt.addValidity(PasswordValidation("Invalid Password")))
        saveSettingBtn.setOnClickListener { presenter.changePassword(settingEmailTxt.text, settingPasswordTxt.text) }
    }


    override fun setValidity(result: Boolean) {
        saveSettingBtn.visibility = if (result) VISIBLE else GONE
    }

    override fun initInjector(): SettingComponent {
        return DaggerSettingComponent.builder()
                .applicationComponent(applicationComponent)
                .settingModule(SettingModule())
                .build()
    }

    override fun showInAppError(message: String) {
        showInAppError("Error fetching profile", message)
    }

    override fun setEmail(it: String) {
        settingEmailTxt.text = it
    }

    override fun closeScreen() {
        activity!!.finish()
    }


    companion object {

        @JvmStatic
        fun newInstance(): Fragment {
            return SettingFragment()
        }
    }
}