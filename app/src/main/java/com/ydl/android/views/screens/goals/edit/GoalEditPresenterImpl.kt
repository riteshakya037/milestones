package com.ydl.android.views.screens.goals.edit

import com.ydl.android.base.BaseRxPresenter
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.GoalManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GoalEditPresenterImpl
@Inject constructor(
        private val goalManager: GoalManager
) : BaseRxPresenter(), GoalEditContract.Presenter {
    override fun updateGoal(goal: Goal) {
        view.showProgressDialog()
        manage(goalManager.createOrUpdate(goal)
                .subscribe({
                    view.hideProgressDialog()
                    view.closeScreen()
                }, { throwable -> view.showInAppError(throwable.message!!) }
                )
        )
    }

    override fun getGoalForId(goalId: String) {
        manage(goalManager.getGoalForId(goalId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayGoal(it)
                }, { throwable -> view.showInAppError(throwable.message!!) }))
    }

    private lateinit var view: GoalEditContract.View

    override fun setView(view: GoalEditContract.View) {
        this.view = view
    }
}