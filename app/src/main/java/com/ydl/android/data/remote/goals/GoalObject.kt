package com.ydl.android.data.remote.goals

data class Goal(val title: String, val purpose: String, val crushedDate: String = "", val milestones: List<Milestone>)

data class Milestone(val title: String, val dueDate: String, val completed: Boolean = false)