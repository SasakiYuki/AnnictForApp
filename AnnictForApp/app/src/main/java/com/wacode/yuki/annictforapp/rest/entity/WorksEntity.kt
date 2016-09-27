package com.wacode.yuki.annictforapp.rest.entity

import java.util.*

/**
 * Created by yuki on 2016/09/26.
 */
data class WorksEntity(
        val works:ArrayList<Work>
){
    data class Work(
            val id:Int,
            val title:String,
            val title_kana:String,
            val media:String,
            val media_text:String,
            val season_name:String,
            val season_name_text:String,
            val released_on:String,
            val released_on_about:String,
            val official_site_url:String,
            val wikipedia_url:String,
            val twitter_username:String,
            val twitter_hashtag:String,
            val episodes_count:Int,
            val watchers_count:Int
    )
}