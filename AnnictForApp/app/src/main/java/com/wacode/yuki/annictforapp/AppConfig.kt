package com.wacode.yuki.annictforapp

/**
 * Created by yuki on 2016/09/25.
 */
object AppConfig {
    fun getApiEndpoint() = String.format("https://%s",BuildConfig.API_HOST)
}