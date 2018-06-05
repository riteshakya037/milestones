package com.ydl.android.data.remote.goals

import com.ydl.android.utils.DateUtils
import org.joda.time.DateTime

data class Goal(val title: String, val purpose: String, val crushedDate: String = "", val milestones: List<Milestone>)

data class Milestone(val title: String, val dueDate: String, val completed: Boolean = false) {
    public val dueDateInDateTime: DateTime
        get() = DateUtils.getIncomingDateFormat(dueDate)
}

enum class Mode {
    IN_PROGRESS, COMPLETED, ALL
}