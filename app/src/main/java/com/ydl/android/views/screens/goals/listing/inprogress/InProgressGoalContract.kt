package com.ydl.android.views.screens.goals.listing.inprogress

import com.ydl.android.base.BasePresenter
import com.ydl.android.base.BaseView
import com.ydl.android.data.remote.goals.Goal


interface InProgressGoalContract {

    interface View : BaseView {

        fun showInAppError(message: String)

        fun addGoal(it: Goal)

    }

    interface Presenter : BasePresenter<View>
}