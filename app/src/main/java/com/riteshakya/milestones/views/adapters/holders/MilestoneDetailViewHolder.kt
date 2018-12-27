package com.riteshakya.milestones.views.adapters.holders

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.riteshakya.milestones.base.BindableViewHolder
import com.riteshakya.milestones.data.remote.goals.Milestone
import com.riteshakya.milestones.utils.isMissed
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_milestones_detail.view.*


class MilestoneDetailViewHolder(itemView: View) : BindableViewHolder<Milestone>(itemView) {
    internal val checkListener = PublishSubject.create<Boolean>()

    override fun bind(item: Milestone) {
        super.bind(item)
        itemView.run {
            goalCountTxt.text = "${adapterPosition + 1}:"
            val title = SpannableString(item.title)
            if (item.completed)
                title.setSpan(StrikethroughSpan(), 0, title.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            goalTitle.text = title
            val summary: SpannableString = when {
                item.isDueToday -> SpannableString("due today")
                item.isBeforeNow -> SpannableString("was due on ${item.dueDate}")
                else -> SpannableString("due by ${item.dueDate}")
            }
            if (item.completed)
                summary.setSpan(StrikethroughSpan(), 0, summary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            goalPurpose.text = summary
            goalCompleted.isChecked = item.completed
            if (item.isMissed()) {
                if (item.isDueToday) {
                    goalStatus.text = "Today!"
                } else {
                    goalStatus.text = "Missed!"
                }
                goalStatus.visibility = VISIBLE
            } else {
                goalStatus.visibility = GONE
            }

            goalCompleted.setOnCheckedChangeListener { _, isChecked ->
                checkListener.onNext(isChecked)
            }
        }
    }
}