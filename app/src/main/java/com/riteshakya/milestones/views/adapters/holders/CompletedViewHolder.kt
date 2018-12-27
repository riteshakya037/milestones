package com.riteshakya.milestones.views.adapters.holders

import android.view.View
import com.riteshakya.milestones.base.BindableViewHolder
import com.riteshakya.milestones.data.remote.goals.Goal
import kotlinx.android.synthetic.main.item_completed_goals.view.*

class CompletedViewHolder(itemView: View) : BindableViewHolder<Goal>(itemView) {
    override fun bind(item: Goal) {
        super.bind(item)
        itemView.goalTitle.text = item.title
        itemView.goalPurpose.text = item.purpose
        itemView.goalCrushedDate.text = "Goal crushed on ${item.crushedDate}"
    }
}