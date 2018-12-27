package com.riteshakya.milestones.base

interface BasePresenter<in T : BaseView> {

    fun onCreate()

    fun onPause()

    fun onResume()

    fun onDestroy()

    fun setView(view: T)
}