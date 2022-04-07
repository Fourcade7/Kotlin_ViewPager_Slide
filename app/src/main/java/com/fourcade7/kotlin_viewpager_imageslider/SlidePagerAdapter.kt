package com.fourcade7.kotlin_viewpager_imageslider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class SlidePagerAdapter(
    var fm:FragmentManager,
    var fragmentlist:ArrayList<Fragment>

): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentlist.get(position)
    }

}