package com.wacode.yuki.annictforapp.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View

/**
 * Created by yuki.n on 2017/02/16.
 */
open class BindingViewHolder<T : ViewDataBinding>(itemView:View) : ViewHolder(itemView){
    val viewDataBinding: T

    init {
        viewDataBinding = DataBindingUtil.bind<T>(itemView)
    }
}