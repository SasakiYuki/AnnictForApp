package com.wacode.yuki.annictforapp.contract

/**
 * Created by yuki on 2016/09/25.
 */
interface AccessTokenContract {
    interface AccessTokenView{
        fun storeAccessToken(accessToken:String)
        fun showError()
    }

    fun setView(view: AccessTokenView)
    fun getAccessToken(code:String)
}