package com.ydl.android.data.remote.goals

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ydl.android.data.helper.DatabaseNames
import com.ydl.android.data.remote.goals.GoalManager.Companion.FALLBACK
import com.ydl.android.data.remote.session.SessionManager
import com.ydl.android.utils.toMap
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class GoalManagerImpl
@Inject constructor(
        sessionManager: SessionManager
) : GoalManager {
    override fun updateMilestoneStatus(goalId: String, position: Int, it: Boolean): Completable {
        val query: DatabaseReference = databaseInstance.reference.child(DatabaseNames.createPath(goalTable, goalId, "milestones", position.toString()))
        val childUpdates = HashMap<String, Any>()
        childUpdates["completed"] = it
        return RxFirebaseDatabase.updateChildren(query, childUpdates)
    }

    private val _tag: String = "GoalManager"

    override fun getGoalForId(goalId: String): Flowable<Goal> {
        val query: DatabaseReference = databaseInstance.reference.child(goalTable + File.separator + goalId)
        return RxFirebaseDatabase.observeValueEvent(query, Goal::class.java).map {
            it.id = goalId
            it
        }.doOnError { throwable ->
            Timber.tag(_tag).e(throwable)
        }
    }

    private val userGoalIdTable: String = DatabaseNames.createPath(DatabaseNames.TABLE_USER_DATA,
            sessionManager.getUserID(), DatabaseNames.TABLE_GOALS)
    private val goalTable: String = DatabaseNames.createPath(DatabaseNames.TABLE_GOALS)
    private val databaseInstance = FirebaseDatabase.getInstance()


    override fun getGoals(): Flowable<Goal> {
        return getListOfGoals().flatMap { goalId ->
            getGoalForId(goalId)
        }
    }

    override fun getGoalsIds(): Single<String> {
        return Observable.concat(
                getListOfGoals().toObservable().take(5000, TimeUnit.MILLISECONDS),
                Observable.just(FALLBACK)
        ).firstOrError()
    }

    private fun getListOfGoals(): Flowable<String> {
        val query: DatabaseReference = databaseInstance.reference.child(userGoalIdTable)
        return RxFirebaseDatabase.observeChildEvent(query, String::class.java).map {
            val data = it
            Timber.tag(_tag).d("Goal with %1\$s found", it.value)
            data.value
        }
    }

    override fun createOrUpdate(goal: Goal): Completable {
        val query: DatabaseReference = databaseInstance.reference.child(goalTable)
        val key = if (goal.id.isEmpty()) {
            query.push().key!!
        } else {
            goal.id
        }
        val postValues = goal.toMap()
        val childUpdates = HashMap<String, Any>()
        childUpdates[key] = postValues
        return RxFirebaseDatabase.updateChildren(query, childUpdates).andThen(updateUserGoalsList(key))
    }

    private fun updateUserGoalsList(key: String): Completable {
        val query: DatabaseReference = databaseInstance.reference.child(userGoalIdTable)
        val childUpdates = HashMap<String, Any>()
        childUpdates[key] = key
        return RxFirebaseDatabase.updateChildren(query, childUpdates)
    }
}

//-LEBZ33yVsn6cVaFcvf-