package com.ydl.android.views.screens.splash


import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerSplashComponent
import com.ydl.android.di.components.SplashComponent
import com.ydl.android.di.modules.SplashModule
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
