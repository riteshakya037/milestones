package com.ydl.android.utils.comparators

import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.utils.getLatestDate
import java.util.*

class GoalTimeComparator : Comparator<Goal> {
    override fun compare(o1: Goal, o2: Goal): Int {
        return o2.milestones.getLatestDate().compareTo(o1.milestones.getLatestDate())
    }
}