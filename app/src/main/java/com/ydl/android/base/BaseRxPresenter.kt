package com.ydl.android.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseRxPresenter {
    private val disposable = CompositeDisposable()

    open fun subscribe() {
    }

    open fun unsubscribe() {
        disposable.clear()
    }

    open fun onDestroy() {
        disposable.dispose()
    }

    open fun onResume() {
    }

    fun manage(subscribe: Disposable) {
        disposable.add(subscribe)
    }
}
