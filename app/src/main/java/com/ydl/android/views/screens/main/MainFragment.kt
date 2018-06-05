package com.ydl.android.views.screens.main

import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import com.ydl.android.R
import com.ydl.android.base.BaseFragment
import com.ydl.android.di.components.DaggerMainComponent
import com.ydl.android.di.components.MainComponent
import com.ydl.android.di.modules.MainModule
import com.ydl.android.views.adapters.GenericFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainFragment : BaseFragment<MainComponent>(), MainContract.View {

    @Inject
    lateinit var genericFragmentAdapter: GenericFragmentAdapter

    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun injectFragment(component: MainComponent) {
        component.inject(this)
    }

    override fun initViews() {
        addPresenter(presenter, this)
        mainScreenViewPager.adapter = genericFragmentAdapter
        mainScreenViewPager.offscreenPageLimit = 2
        genericFragmentAdapter.addFragment(navigator.getInProgressGoalsFragment(context!!), "In Progress")
        genericFragmentAdapter.addFragment(navigator.getCompletedGoalsFragment(context!!), "Crushed")
        mainScreenTabLayout.setupWithViewPager(mainScreenViewPager)
        mainScreenCreateGoal.setOnClickListener { createNewGoal() }

        mainScreenMenuBtn.setOnClickListener { mainScreenDrawer.openDrawer(GravityCompat.START) }
        navSettings.setOnClickListener { println("Setting") }
        navHelp.setOnClickListener { println("Help") }
        navLogout.setOnClickListener { println("Logout") }
    }

    override fun showInAppError(message: String) {
        showInAppError("Error fetching goals")
    }

    override fun createNewGoal() {
        navigator.navigateToCreateGoal(activity!!)
    }

    override fun setCurrentGoals(completedCount: Int) {
        currentGoalTxt.text = "$completedCount"
    }

    override fun setTotalGoals(size: Int) {
        totalGoalTxt.text = "/$size"
    }

    override fun initInjector(): MainComponent {
        return DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(MainModule(activity as AppCompatActivity))
                .build()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
