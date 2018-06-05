package com.ydl.android.views.components

import android.content.Context
import android.support.design.widget.TabLayout
import android.util.AttributeSet
import android.view.ViewGroup


class CustomTabLayout : TabLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val tabLayout = getChildAt(0) as ViewGroup
        val childCount = tabLayout.childCount

        val displayMetrics = context.resources.displayMetrics
        val tabMinWidth = displayMetrics.widthPixels / childCount

        for (i in 0 until childCount) {
            tabLayout.getChildAt(i).minimumWidth = tabMinWidth
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}