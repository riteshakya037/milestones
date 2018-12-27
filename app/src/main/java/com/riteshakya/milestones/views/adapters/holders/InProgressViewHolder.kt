package com.riteshakya.milestones.views.adapters.holders

import android.text.Spannable
import android.text.SpannableString
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.riteshakya.milestones.R
import com.riteshakya.milestones.base.BindableViewHolder
import com.riteshakya.milestones.data.remote.goals.Goal
import com.riteshakya.milestones.utils.*
import com.riteshakya.milestones.views.helpers.CustomTypefaceSpan
import kotlinx.android.synthetic.main.item_in_progress_goals.view.*
import org.joda.time.DateTime


class InProgressViewHolder(itemView: View) : BindableViewHolder<Goal>(itemView) {
    override fun bind(item: Goal) {
        super.bind(item)
        itemView.goalTitle.text = item.title
        val nextMilestone = item.milestones.getNextMilestone()
        val text: String
        val daysBetween = DateUtils.getDaysBetween(DateTime(), nextMilestone.dueDateInDateTime)
        text =
                when {
                    nextMilestone.isDueToday -> " due today"
                    nextMilestone.isAfterNow -> context.resources.getQuantityString(R.plurals.next_goal_prefix, daysBetween, daysBetween)
                    else -> context.resources.getQuantityString(R.plurals.next_goal_prefix_late, daysBetween, daysBetween)
                }

        val prefix = nextMilestone.title
        val str = SpannableString("$prefix $text")
        str.setSpan(CustomTypefaceSpan("", FontCache["open_sans_bold.ttf", context]), prefix.length, str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        itemView.goalPurpose.text = str
        itemView.goalProgress.text = "${item.milestones.getCompletedMilestonesCount()} / ${item.milestones.size}"
        if (item.milestones.checkMissed()) {
            if (item.milestones.hasMilestoneToday()) {
                itemView.goalStatus.text = "Today!"
            } else {
                itemView.goalStatus.text = "Missed!"
            }
            itemView.goalStatus.visibility = VISIBLE
        } else {
            itemView.goalStatus.visibility = GONE
        }

    }


}