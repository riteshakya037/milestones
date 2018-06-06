package com.ydl.android.data.remote.goals

import com.ydl.android.utils.DateUtils
import org.joda.time.DateTime

data class Goal(val title: String = "", val purpose: String = "", val crushedDate: String = "", val milestones: List<Milestone> = ArrayList()) {
    internal var id: String = ""

    override fun equals(other: Any?): Boolean {
        if (other !is Goal) return false
        return super.equals(other) || this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

data class Milestone(val title: String = "", val dueDate: String = "", val completed: Boolean = false) {
    val dueDateInDateTime: DateTime
        get() = DateUtils.getIncomingDateFormat(dueDate)
}

enum class Mode {
    IN_PROGRESS, COMPLETED, ALL
}