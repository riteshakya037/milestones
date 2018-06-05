package com.ydl.android.utils

import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.Milestone
import org.joda.time.DateTime

fun List<Milestone>.getLatestDate(): DateTime {
    return this.maxBy { milestone -> milestone.dueDateInDateTime.millis }!!.dueDateInDateTime
}

fun List<Milestone>.getCompletedMilestonesCount(): Int {
    return this.count { it.completed }
}

fun List<Milestone>.checkMissed(): Boolean {
    return this.map { !it.completed && it.dueDateInDateTime.isBeforeNow }.contains(true)
}

fun List<Milestone>.getNextMilestone(): Milestone {
    return firstOrNull { it.dueDateInDateTime.isAfterNow } ?: this.last()
}

fun List<Goal>.getCompletedCount(): Int {
    return this.count { it.milestones.getCompletedMilestonesCount() == 3 }
}