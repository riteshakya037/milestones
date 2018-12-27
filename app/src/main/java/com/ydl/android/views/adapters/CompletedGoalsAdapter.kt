package com.ydl.android.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ydl.android.R
import com.ydl.android.data.remote.goals.Goal
import com.ydl.android.data.remote.goals.Mode
import com.ydl.android.utils.comparators.GoalTimeComparator
import com.ydl.android.utils.filterMode
import com.ydl.android.views.adapters.holders.CompletedViewHolder
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * @author Ritesh Shakya
 */

class CompletedGoalsAdapter @Inject constructor() : RecyclerView.Adapter<CompletedViewHolder>() {

    private var mList: ArrayList<Goal> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_completed_goals, parent, false)
        return CompletedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompletedViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    fun addGoal(goal: Goal) {
        if (!mList.contains(goal)) {
            mList.add(goal)
        } else {
            mList[mList.indexOf(goal)] = goal
        }
        mList = ArrayList(mList.filterMode(Mode.COMPLETED))
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
