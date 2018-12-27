package com.riteshakya.milestones.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseRxPresenter {
    private val disposable = CompositeDisposable()

    open fun onCreate() {
    }

    open fun onDestroy() {
        disposable.dispose()
        disposable.clear()
    }

    open fun onPause() {
    }

    open fun onResume() {
    }

    fun manage(subscribe: Disposable) {
        disposable.add(subscribe)
    }
}
