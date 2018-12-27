package com.riteshakya.milestones.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.riteshakya.milestones.MilestonesApplication
import com.riteshakya.milestones.R
import com.riteshakya.milestones.di.components.ActivityComponent
import com.riteshakya.milestones.di.components.ApplicationComponent
import com.riteshakya.milestones.di.components.DaggerActivityComponent
import com.riteshakya.milestones.di.modules.ActivityModule
import com.riteshakya.milestones.utils.navigation.Navigator
import com.riteshakya.milestones.utils.replaceFragmentInActivity

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