package com.riteshakya.milestones.utils.comparators

import com.riteshakya.milestones.data.remote.goals.Goal
import com.riteshakya.milestones.utils.getLatestDate
import java.util.*

class GoalTimeComparator : Comparator<Goal> {
    override fun compare(o1: Goal, o2: Goal): Int {
        return o2.milestones.getLatestDate().compareTo(o1.milestones.getLatestDate())
    }
}