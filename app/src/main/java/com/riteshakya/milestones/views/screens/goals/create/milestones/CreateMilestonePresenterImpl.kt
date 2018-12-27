package com.riteshakya.milestones.views.screens.goals.create.milestones

import com.riteshakya.milestones.base.BaseRxPresenter
import com.riteshakya.milestones.data.remote.goals.Goal
import com.riteshakya.milestones.data.remote.goals.GoalManager
import com.riteshakya.milestones.data.remote.goals.Milestone
import com.riteshakya.milestones.views.screens.goals.create.GoalFlowPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CreateMilestonePresenterImpl
@Inject constructor(
        private val goalManager: GoalManager,
        private val goalFlowPresenter: GoalFlowPresenter
) : BaseRxPresenter(), CreateMilestoneContract.Presenter {

    private lateinit var view: CreateMilestoneContract.View

    override fun setView(view: CreateMilestoneContract.View) {
        this.view = view
    }


    override fun createGoal(goal: String, purpose: String, milestones: List<Milestone>) {
        view.showProgressDialog()
        manage(goalManager.createOrUpdate(Goal(goal, purpose, milestones = milestones))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.goalFlowPresenter.navigateToGoalConfirmation()
                    view.hideProgressDialog()
                }, { throwable -> view.showInAppError(throwable.message!!) })
        )
    }
}