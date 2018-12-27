package com.ydl.android.views.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import javax.inject.Inject

class GenericFragmentAdapter @Inject constructor(var context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
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
