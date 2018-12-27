package com.riteshakya.milestones.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface GoalManager {
    companion object {
        const val FALLBACK: String = "FALLBACK"
    }

    fun createOrUpdate(goal: Goal): Completable
    fun getGoalsIds(): Single<String>
    fun getGoals(): Flowable<Goal>
    fun getGoalForId(goalId: String): Flowable<Goal>
    fun updateMilestoneStatus(goalId: String, position: Int, it: Boolean): Completable
}