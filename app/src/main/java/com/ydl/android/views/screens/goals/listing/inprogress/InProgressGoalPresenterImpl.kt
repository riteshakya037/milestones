package com.ydl.android.views.screens.goals.listing.inprogress

import com.ydl.android.base.BaseRxPresenter
import com.ydl.android.data.remote.goals.GoalManager
import com.ydl.android.data.remote.goals.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class InProgressGoalPresenterImpl
@Inject constructor(
        private val goalManager: GoalManager
) : BaseRxPresenter(), InProgressGoalContract.Presenter {
    private lateinit var view: InProgressGoalContract.View

    override fun setView(view: InProgressGoalContract.View) {
        this.view = view
    }

    override fun subscribe() {
        manage(goalManager.getGoals(Status.IN_PROGRESS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.addGoal(it)
                        }
                        ,
                        { throwable -> view.showInAppError(throwable.message!!) }
                )
        )
    }
}