package com.riteshakya.milestones.views.screens.goals.listing.inprogress

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.goals.GoalManager
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