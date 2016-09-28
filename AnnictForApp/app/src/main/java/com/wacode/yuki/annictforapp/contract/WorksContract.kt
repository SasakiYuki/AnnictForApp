package com.wacode.yuki.annictforapp.contract

import com.wacode.yuki.annictforapp.rest.entity.WorksEntity

/**
 * Created by yuki on 2016/09/26.
 */
interface WorksContract {
    interface WorksView{
        fun showWorks(entity:WorksEntity)
        fun showError()
    }
    fun setViews(view:WorksView)
    fun getWorks()
}