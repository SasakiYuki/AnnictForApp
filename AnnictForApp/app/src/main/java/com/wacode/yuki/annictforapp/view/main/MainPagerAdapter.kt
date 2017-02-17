package com.wacode.yuki.annictforapp.view.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wacode.yuki.annictforapp.fragment.WorkRecyclerFragment

/**
 * Created by yuki.n on 2017/02/13.
 */
class MainPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> WorkRecyclerFragment.newInstance()
            else -> WorkRecyclerFragment.newInstance(year = "2016")
        }

    }

    override fun getCount(): Int {
        return 2
    }

}