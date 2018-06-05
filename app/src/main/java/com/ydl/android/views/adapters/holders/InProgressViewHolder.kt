package com.ydl.android.views.adapters.holders

import android.text.Spannable
import android.text.SpannableString
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ydl.android.R
import com.ydl.android.base.BindableViewHolder
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.utils.*
import com.ydl.android.views.helpers.CustomTypefaceSpan
import kotlinx.android.synthetic.main.item_in_progress_goals.view.*
import org.joda.time.DateTime


class InProgressViewHolder(itemView: View) : BindableViewHolder<Goal>(itemView) {
    override fun bind(item: Goal) {
        super.bind(item)
        itemView.goalTitle.text = item.title
        val nextMilestone = item.milestones.getNextMilestone()
        val text: String
        val daysBetween = DateUtils.getDaysBetween(DateTime(), nextMilestone.dueDateInDateTime)
        text = context.resources.getQuantityString(
                if (nextMilestone.dueDateInDateTime.isAfterNow)
                    R.plurals.next_goal_prefix
                else
                    (R.plurals.next_goal_prefix_late)
                , daysBetween, daysBetween)
        val prefix = nextMilestone.title
        val str = SpannableString("$prefix $text")
        str.setSpan(CustomTypefaceSpan("", FontCache["open_sans_bold.ttf", context]), prefix.length, str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        itemView.goalPurpose.text = str
        itemView.goalProgress.text = "${item.milestones.getCompletedMilestonesCount()} / ${item.milestones.size}"
        itemView.goalStatus.visibility = if (item.milestones.checkMissed()) VISIBLE else GONE

    }


}