package com.riteshakya.milestones.views.screens.goals.listing.completed

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.goals.GoalManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CompletedGoalPresenterImpl
@Inject constructor(
        private val goalManager: GoalManager
) : BaseRxPresenter(), CompletedGoalContract.Presenter {
    private lateinit var view: CompletedGoalContract.View

    override fun setView(view: CompletedGoalContract.View) {
        this.view = view
    }

    override fun onCreate() {
        manage(goalManager.getGoals()
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