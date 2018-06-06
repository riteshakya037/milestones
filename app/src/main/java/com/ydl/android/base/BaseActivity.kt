package com.ydl.android.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ydl.android.MilestonesApplication
import com.ydl.android.R
import com.ydl.android.di.components.ActivityComponent
import com.ydl.android.di.components.ApplicationComponent
import com.ydl.android.di.components.DaggerActivityComponent
import com.ydl.android.di.modules.ActivityModule
import com.ydl.android.utils.navigation.Navigator
import com.ydl.android.utils.replaceFragmentInActivity

abstract class BaseActivity : AppCompatActivity() {

    private var currentFragment: BaseFragment<*>? = null
    protected var navigator: Navigator = Navigator()
    protected abstract val presenter: BasePresenter<*>?

    fun addFragment(fragment: Fragment) {
        if (fragment is BaseFragment<*>) currentFragment = fragment
        replaceFragmentInActivity(fragment, R.id.content)
    }

    protected open val contextView = R.layout.activity_fragment_container_noactionbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contextView)
        initActivity(savedInstanceState)
    }

    abstract fun initActivity(savedInstanceState: Bundle?)

    fun getApp(): MilestonesApplication {
        return application as MilestonesApplication
    }

    override fun onStart() {
        super.onStart()
        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }


    private val applicationComponent: ApplicationComponent
        get() = (application as MilestonesApplication).appComponent

    private val activityModule: ActivityModule
        get() = ActivityModule(this)

    protected fun initInjector(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(activityModule)
                .build()
    }
}