package com.ydl.android.views.adapters.holders

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.ydl.android.base.BindableViewHolder
import com.ydl.android.data.remote.goals.Milestone
import com.ydl.android.utils.isMissed
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_milestones_detail.view.*


class MilestoneDetailViewHolder(itemView: View) : BindableViewHolder<Milestone>(itemView) {
    internal val checkListener = PublishSubject.create<Boolean>()

    override fun bind(item: Milestone) {
        super.bind(item)
        itemView.goalCountTxt.text = "${adapterPosition + 1}:"
        itemView.goalTitle.text = item.title
        itemView.goalPurpose.text = "due by ${item.dueDate}"
        itemView.goalCompleted.isChecked = item.completed
        itemView.goalStatus.visibility = if (item.isMissed()) VISIBLE else GONE

        itemView.goalCompleted.setOnCheckedChangeListener { _, isChecked ->
            checkListener.onNext(isChecked)
        }
    }
}