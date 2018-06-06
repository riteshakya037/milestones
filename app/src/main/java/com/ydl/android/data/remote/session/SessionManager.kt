package com.ydl.android.data.remote.session

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

interface SessionManager {

    fun login(email: String,
              password: String): Maybe<Unit>

    fun forgotPassword(email: String): Completable

    fun changePassword(username: String, newPassword: String): Observable<String>

    fun register(email: String, password: String): Maybe<Unit>

    fun hasSession(): Observable<Boolean>
}