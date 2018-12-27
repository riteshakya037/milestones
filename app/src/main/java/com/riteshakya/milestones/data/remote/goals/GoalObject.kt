package com.riteshakya.milestones.data.remote.goals

import com.riteshakya.milestones.utils.DateUtils
import org.joda.time.DateTime

data class Goal(var title: String = "", var purpose: String = "", var crushedDate: String = "", val milestones: List<Milestone> = ArrayList()) {
    internal var id: String = ""
    var userId: String = ""
    var addedDate: String = ""
    var updatedDate: String = ""

    override fun equals(other: Any?): Boolean {
        if (other !is Goal) return false
        return super.equals(other) || this.id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

data class Milestone(var title: String = "", var dueDate: String = "", val completed: Boolean = false) {
    val dueDateInDateTime: DateTime
        get() = DateUtils.getIncomingDateFormat(dueDate)
    val isDueToday: Boolean
        get() = dueDateInDateTime.withTimeAtStartOfDay() == DateTime().withTimeAtStartOfDay()
    val isBeforeNow: Boolean
        get() = dueDateInDateTime.isBeforeNow
    val isAfterNow: Boolean
        get() = dueDateInDateTime.isAfterNow
}

enum class Mode {
    IN_PROGRESS, COMPLETED, ALL
}