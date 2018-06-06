package com.ydl.android.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ydl.android.R
import com.ydl.android.data.remote.goals.Milestone
import com.ydl.android.views.adapters.holders.MilestoneDetailViewHolder
import javax.inject.Inject

/**
 * @author Ritesh Shakya
 */

class MilestoneDetailAdapter @Inject constructor() : RecyclerView.Adapter<MilestoneDetailViewHolder>() {

    private val mList: ArrayList<Milestone> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilestoneDetailViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_milestones_detail, parent, false)
        return MilestoneDetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MilestoneDetailViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    fun addMilestones(milestones: List<Milestone>) {
        mList.clear()
        mList.addAll(milestones)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    fun getItems(): ArrayList<Milestone> {
        return mList
    }
}
