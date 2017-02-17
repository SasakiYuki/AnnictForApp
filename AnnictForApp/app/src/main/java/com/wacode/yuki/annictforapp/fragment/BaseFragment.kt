package com.wacode.yuki.annictforapp.fragment

import android.support.v4.app.Fragment

/**
 * Created by yuki.n on 2017/02/13.
 */
abstract class BaseFragment : Fragment() {

    companion object {
        const val ARG_SEASON = "arg_season"
        const val ARG_YEAR = "arg_year"
    }
}