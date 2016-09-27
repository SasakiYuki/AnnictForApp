package com.wacode.yuki.annictforapp.utils

import android.content.Context
import jp.hunza.blog.utils.PrefUtils

/**
 * Created by yuki on 2016/09/26.
 */
class PrefManager(val context: Context) {
    private val ACCOUNT_MANAGER = "account_manager"

    val AccessToken:String
        get() = PrefUtils[context,ACCOUNT_MANAGER,""]

    fun setAccessToken(accessToken:String) = PrefUtils.put(context,ACCOUNT_MANAGER,accessToken)
}