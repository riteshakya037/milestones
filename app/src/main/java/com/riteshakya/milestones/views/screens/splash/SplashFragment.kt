package com.riteshakya.milestones.views.screens.splash


import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BaseFragment
import com.riteshakya.milestones.di.components.DaggerSplashComponent
import com.riteshakya.milestones.di.components.SplashComponent
import com.riteshakya.milestones.di.modules.SplashModule
import javax.inject.Inject


class SplashFragment : BaseFragment<SplashComponent>(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override fun getLayout() = R.layout.fragment_splash

    override fun injectFragment(component: SplashComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
    }

    override fun initInjector(): SplashComponent {
        return DaggerSplashComponent.builder()
                .applicationComponent(activity().getApp().appComponent)
                .splashModule(SplashModule())
                .build()
    }

    override fun navigateToLandingScreen() {
        navigator.navigateToLandingScreen(activity())
        activity!!.finish()
    }

    override fun navigateToMainScreen() {
        navigator.navigateToMainScreen(activity())
        activity!!.finish()
    }


    override fun onConfigLoadFailed(throwable: Throwable) {
        showInAppError("Encountered an exception", throwable.message!!, object : Callback {
            override fun onDismissed() {
                activity!!.finish()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()
    }
}
