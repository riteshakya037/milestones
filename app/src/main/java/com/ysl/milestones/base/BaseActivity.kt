package com.ysl.milestones.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ysl.milestones.MilestonesApplication
import com.ysl.milestones.R
import com.ysl.milestones.di.components.ActivityComponent
import com.ysl.milestones.di.components.ApplicationComponent
import com.ysl.milestones.di.components.DaggerActivityComponent
import com.ysl.milestones.di.modules.ActivityModule
import com.ysl.milestones.utils.navigation.Navigator
import com.ysl.milestones.utils.replaceFragmentInActivity

abstract class BaseActivity : AppCompatActivity() {

    private var currentFragment: BaseFragment<*>? = null
    protected var navigator: Navigator = Navigator()
    protected abstract val presenter: BasePresenter<BaseView>?
    protected abstract val isFragmentContainer: Boolean

    fun addFragment(fragment: Fragment) {
        if (fragment is BaseFragment<*>) currentFragment = fragment
        replaceFragmentInActivity(fragment, R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isFragmentContainer)
            setContentView(R.layout.activity_fragment_container_noactionbar)
    }

    fun getApp(): MilestonesApplication {
        return application as MilestonesApplication
    }

    override fun onStart() {
        super.onStart()
        presenter?.subscribe()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter?.unsubscribe()
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