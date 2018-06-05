package com.ysl.milestones.base

interface BasePresenter<in T : BaseView> {

    fun subscribe()

    fun unsubscribe()

    fun onResume()

    fun onDestroy()

    fun setView(view: T)
}