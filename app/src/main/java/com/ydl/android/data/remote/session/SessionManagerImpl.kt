package com.ydl.android.data.remote.session

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.ydl.android.data.exceptions.EmailNotFoundException
import durdinapps.rxfirebase2.RxFirebaseAuth
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class SessionManagerImpl
@Inject constructor() : SessionManager {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String): Maybe<Unit> {
        return RxFirebaseAuth.signInWithEmailAndPassword(firebaseAuth, email, password)
                .map { Unit }
    }

    override fun forgotPassword(email: String): Completable {
        return RxFirebaseAuth.sendPasswordResetEmail(firebaseAuth, email)
                .onErrorResumeNext({ throwable ->
                    var output: Throwable = throwable
                    when (throwable) {
                        is TimeoutException -> output = TimeoutException("Connection timeout, please check your network connection and try again")
                        is SocketTimeoutException -> output = TimeoutException("Connection timeout, please check your network connection and try again")
                        is UnknownHostException -> output = UnknownHostException("There is no Internet connection available, please make sure that you are connected to the Internet")
                        is FirebaseException ->
                            if ((throwable.message!!.contains("EMAIL_NOT_FOUND"))) {
                                output = EmailNotFoundException()
                            }
                        else -> Timber.e(throwable)
                    }
                    Completable.error(output)
                })
    }

    override fun changePassword(username: String, newPassword: String): Observable<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(email: String, password: String): Maybe<Unit> {
        return RxFirebaseAuth.createUserWithEmailAndPassword(firebaseAuth, email, password)
                .map { Unit }
    }

    override fun hasSession(): Observable<Boolean> {
        return Observable.just(firebaseAuth.currentUser != null)
                .delay(300, TimeUnit.MILLISECONDS)
    }

}