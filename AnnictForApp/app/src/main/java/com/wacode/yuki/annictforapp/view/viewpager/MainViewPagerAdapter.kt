package com.wacode.yuki.annictforapp.view.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.wacode.yuki.annictforapp.fragment.SearchFragment

/**
 * Created by yuki on 2016/09/28.
 */
class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> SearchFragment.newInstance(android.R.color.transparent)
            1 -> SearchFragment.newInstance(android.R.color.holo_green_light)
            2 -> SearchFragment.newInstance(android.R.color.holo_red_dark)
            else -> null
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "ページ" + (position + 1)
    }
}
