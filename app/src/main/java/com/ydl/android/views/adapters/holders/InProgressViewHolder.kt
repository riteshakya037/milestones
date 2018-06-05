package com.ydl.android.views.adapters.holders

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ydl.android.base.BindableViewHolder
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.utils.checkMissed
import com.ydl.android.utils.getCompletedMilestonesCount
import com.ydl.android.utils.getNextMilestone
import kotlinx.android.synthetic.main.item_in_progress_goals.view.*

class InProgressViewHolder(itemView: View) : BindableViewHolder<Goal>(itemView) {
    override fun bind(item: Goal) {
        super.bind(item)
        itemView.goalTitle.text = item.title
        itemView.goalPurpose.text = item.milestones.getNextMilestone().title
        itemView.goalProgress.text = "${item.milestones.getCompletedMilestonesCount()} / ${item.milestones.size}"
        itemView.goalStatus.visibility = if (item.milestones.checkMissed()) VISIBLE else GONE

    }
}