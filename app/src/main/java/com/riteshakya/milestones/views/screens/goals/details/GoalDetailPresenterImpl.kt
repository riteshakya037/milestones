package com.riteshakya.milestones.views.screens.goals.details

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.goals.GoalManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GoalDetailPresenterImpl
@Inject constructor(
        private val goalManager: GoalManager
) : BaseRxPresenter(), GoalDetailsContract.Presenter {


    override fun getGoalForId(goalId: String) {
        manage(goalManager.getGoalForId(goalId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayGoal(it)
                }, { throwable -> view.showInAppError(throwable.message!!) }))
    }

    private lateinit var view: GoalDetailsContract.View

    override fun setView(view: GoalDetailsContract.View) {
        this.view = view
    }
}