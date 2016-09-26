package com.wacode.yuki.annictforapp.utils

import com.wacode.yuki.annictforapp.BuildConfig
import java.util.*

/**
 * Created by yuki on 2016/09/26.
 */
class OAuthQueryBuilder(val code:String) {
    private val clientId = BuildConfig.CLIENT_ID
    private val clientSecret = BuildConfig.CLIENT_SECRET
    private val redirectUrl = BuildConfig.REDIRECT_URL

    fun toQueryMap():Map<String,String>{
        return object : HashMap<String, String>(){
            init {
                put(OAuthHelper.Q_CLIENT_ID,clientId)
                put(OAuthHelper.Q_CLIENT_SECRET,clientSecret)
                put(OAuthHelper.Q_GRANT_TYPE,OAuthHelper.GRANTT_TYPE)
                put(OAuthHelper.REDIRECT_URL,redire ctUrl)
                put(OAuthHelper.Q_CODE,code)
            }
        }
    }
}