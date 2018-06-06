package com.ydl.android.views.screens.setting

import android.support.v4.app.Fragment
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerSettingComponent
import com.ydl.android.di.components.SettingComponent
import com.ydl.android.di.modules.SettingModule
import com.ydl.android.utils.addValidity
import com.ydl.android.utils.validation.types.EmailValidation
import com.ydl.android.utils.validation.types.PasswordValidation
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