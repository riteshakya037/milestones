package com.ydl.android.utils

import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.Milestone
import com.ydl.android.data.remote.goals.Mode
import org.joda.time.DateTime

fun List<Milestone>.getLatestDate(): DateTime {
    return this.maxBy { milestone -> milestone.dueDateInDateTime.millis }!!.dueDateInDateTime
}

fun List<Milestone>.getCompletedMilestonesCount(): Int {
    return this.count { it.completed }
}

fun List<Milestone>.checkMissed(): Boolean {
    return this.map { it.isMissed() }.contains(true)
}

fun Milestone.isMissed(): Boolean {
    return !this.completed && this.dueDateInDateTime.isBeforeNow
}

fun List<Milestone>.getNextMilestone(): Milestone {
    return firstOrNull { it.dueDateInDateTime.isAfterNow } ?: this.last()
}

fun List<Goal>.getCompletedCount(): Int {
    return this.count { it.milestones.getCompletedMilestonesCount() == 3 }
}


fun List<Goal>.filterMode(mode: Mode): List<Goal> {
    return this.filter {
        when (mode) {
            Mode.ALL -> true
            Mode.COMPLETED -> it.milestones.getCompletedMilestonesCount() == 3
            Mode.IN_PROGRESS -> it.milestones.getCompletedMilestonesCount() < 3
        }
    }
}