package com.ydl.android.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GoalManagerImpl
@Inject constructor(

) : GoalManager {
    override fun getGoalsIds(): Observable<List<String>> {
        return Observable.create { it.onNext(ArrayList()) }
    }

    override fun createGoal(goal: Goal): Completable {
        return Completable.create { it.onComplete() }
    }
}