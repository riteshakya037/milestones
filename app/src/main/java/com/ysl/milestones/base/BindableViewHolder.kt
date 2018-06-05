package com.ysl.milestones.base

import android.content.Context
import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Ritesh Shakya
 */

abstract class BindableViewHolder<T : Any>(itemView: View, val context: Context = itemView.context) : RecyclerView.ViewHolder(itemView) {


    lateinit var boundItem: T

    @CallSuper
    open fun bind(item: T) {
        boundItem = item
    }
}
