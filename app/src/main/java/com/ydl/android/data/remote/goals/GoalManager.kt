package com.ydl.android.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Observable

interface GoalManager {
    fun createGoal(goal: Goal): Completable
    fun getGoalsIds(): Observable<List<String>>
    fun getGoals(mode: Mode): Observable<Goal>
    fun getGoalForId(goalId: String): Observable<Goal>
}