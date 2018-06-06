package com.ydl.android.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

interface GoalManager {
    companion object {
        const val FALLBACK: String = "FALLBACK"
    }

    fun createGoal(goal: Goal): Completable
    fun getGoalsIds(): Single<String>
    fun getGoals(mode: Mode): Flowable<Goal>
    fun getGoalForId(goalId: String): Maybe<Goal>
}