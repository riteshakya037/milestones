package com.ydl.android.views.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import javax.inject.Inject

class LandingFragmentAdapter @Inject constructor(var context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val pages: ArrayList<Fragment> = ArrayList()
    private val titles: ArrayList<String> = ArrayList()

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        pages.add(fragment)
        titles.add(title)
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}
