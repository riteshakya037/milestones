package com.riteshakya.milestones.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riteshakya.milestones.R
import com.riteshakya.milestones.data.remote.goals.Goal
import com.riteshakya.milestones.data.remote.goals.GoalManager
import com.riteshakya.milestones.data.remote.goals.Milestone
import com.riteshakya.milestones.views.adapters.holders.MilestoneDetailViewHolder
import javax.inject.Inject

/**
 * @author Ritesh Shakya
 */

class MilestoneDetailAdapter @Inject constructor(private val goalManager: GoalManager) : RecyclerView.Adapter<MilestoneDetailViewHolder>() {

    private lateinit var goal: Goal
    private val mList: ArrayList<Milestone> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilestoneDetailViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_milestones_detail, parent, false)
        return MilestoneDetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MilestoneDetailViewHolder, position: Int) {
        holder.bind(goal.milestones[position])
        holder.checkListener.doOnNext {
            goalManager.updateMilestoneStatus(goal.id, position, it).subscribe()
        }.subscribe()
    }

    private fun addMilestones(milestones: List<Milestone>) {
        mList.clear()
        mList.addAll(milestones)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    fun setGoal(goal: Goal) {
        this.goal = goal
        addMilestones(goal.milestones)
    }
}
