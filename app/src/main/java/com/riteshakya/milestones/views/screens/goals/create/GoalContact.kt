package com.riteshakya.milestones.views.screens.goals.create

/**
 * author riteshakya037
 */
interface GoalFlowPresenter {
    fun navigateToCreateMilestones(goalTitle: String, goalPurpose: String)

    fun navigateToGoalConfirmation()
}