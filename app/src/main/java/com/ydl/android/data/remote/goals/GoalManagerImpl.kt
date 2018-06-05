package com.ydl.android.data.remote.goals

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GoalManagerImpl
@Inject constructor(

) : GoalManager {

    override fun getGoals(iN_PROGRESS: Status): Observable<Goal> {
        val milestones = ArrayList<Milestone>()
        milestones.add(Milestone("Buy piano books", "4 Jan, 2018", true))
        milestones.add(Milestone("Get a used piano from Craigslist", "4 Jun, 2018", false))
        milestones.add(Milestone("Sign up for piano lessons", "25 Dec, 2018", false))
        val goal = Goal("Learn to play piano", "I want to flex my right brain", milestones = milestones)

        return Observable.just(goal)
    }

    override fun getGoalsIds(): Observable<List<String>> {
        return Observable.create { it.onNext(arrayListOf("test")) }
    }

    override fun createGoal(goal: Goal): Completable {
        return Completable.create { it.onComplete() }
    }
}