package com.ydl.android.base

import android.content.Context
import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView

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
