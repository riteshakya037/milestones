package com.ydl.android.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Observable

interface GoalManager {
    fun createGoal(goal: Goal): Completable
    fun getGoalsIds(): Observable<List<String>>
    fun getGoals(iN_PROGRESS: Status): Observable<Goal>
}