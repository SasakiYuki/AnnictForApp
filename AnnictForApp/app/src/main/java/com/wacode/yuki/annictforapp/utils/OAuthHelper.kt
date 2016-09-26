package com.wacode.yuki.annictforapp.utils

import android.os.Build
import com.wacode.yuki.annictforapp.AppConfig
import com.wacode.yuki.annictforapp.BuildConfig

object OAuthHelper {

    const val OAUTH_URL = "/oauth/authorize/"
    const val Q_CLIENT_ID = "client_id"
    const val Q_CLIENT_SECRET = "client_secret"
    const val Q_GRANT_TYPE = "grant_type"
    const val Q_CODE = "code"
    const val Q_REDIRECT_URL = "redirect_uri"
    const val Q_RESPONSE_TYPE = "response_type"
    const val Q_SCOPE = "scope"

    const val REDIRECT_URL = BuildConfig.REDIRECT_URL
    const val RESPONSE_TYPE ="code"
    const val SCOPE = "read+write"
    const val GRANTT_TYPE = "authorization_code"


    val builder:String
        get() = "${AppConfig.getApiEndpoint()}$OAUTH_URL?$Q_CLIENT_ID=${BuildConfig.CLIENT_ID}&$Q_REDIRECT_URL=$REDIRECT_URL&$Q_RESPONSE_TYPE=$RESPONSE_TYPE&$Q_SCOPE=$SCOPE"

}