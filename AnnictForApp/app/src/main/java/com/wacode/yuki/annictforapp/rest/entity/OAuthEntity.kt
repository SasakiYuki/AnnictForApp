package com.wacode.yuki.annictforapp.rest.entity

/**
 * Created by yuki on 2016/09/26.
 */
data class OAuthEntity (
        val access_token:String,
        val token_type:String,
        val scope:String,
        val created_at:Int
)