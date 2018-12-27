package com.riteshakya.milestones.utils

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * author riteshakya037
 */
@Suppress("UNCHECKED_CAST")
inline fun <T : Any, R : Any> Iterable<Observable<T>>.combineLatest(crossinline combineFunction: (args: List<T>) -> R)
        : Observable<R> = Observable.combineLatest(this) {
    combineFunction(it.asList().map { it as T })
}

fun <R> Observable<R>.parseError(): Observable<R> {
    return this.onErrorResumeNext(errorCasting())
}

private fun <T> errorCasting(): Function<Throwable, ObservableSource<T>> {
    return Function { throwable ->
        var output: Throwable = throwable
        when (throwable) {
            is TimeoutException -> output = TimeoutException("Connection timeout, please check your network connection and try again")
            is SocketTimeoutException -> output = TimeoutException("Connection timeout, please check your network connection and try again")
            is UnknownHostException -> output = UnknownHostException("There is no Internet connection available, please make sure that you are connected to the Internet")
            else -> Timber.e(throwable)
        }
        Observable.error(output)
    }
}
