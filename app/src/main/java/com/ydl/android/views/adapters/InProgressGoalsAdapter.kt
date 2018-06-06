package com.ydl.android.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ydl.android.R
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.Mode
import com.ydl.android.utils.comparators.GoalTimeComparator
import com.ydl.android.utils.filterMode
import com.ydl.android.views.adapters.holders.InProgressViewHolder
import io.reactivex.subjects.PublishSubject
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * @author Ritesh Shakya
 */

class InProgressGoalsAdapter @Inject constructor() : RecyclerView.Adapter<InProgressViewHolder>() {

    internal val singleClickPublish = PublishSubject.create<Goal>()
    private var mList: ArrayList<Goal> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InProgressViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_in_progress_goals, parent, false)
        return InProgressViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InProgressViewHolder, position: Int) {
        holder.bind(mList[position])
        holder.itemView.setOnClickListener({
            singleClickPublish.onNext(mList[position])
        })
    }

    fun addGoal(goal: Goal) {
        if (!mList.contains(goal)) {
            mList.add(goal)
        } else {
            mList[mList.indexOf(goal)] = goal
        }
        mList = ArrayList(mList.filterMode(Mode.IN_PROGRESS))
        Collections.sort(mList, GoalTimeComparator())
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    fun getItems(): ArrayList<Goal> {
        return mList
    }
}
