package com.wacode.yuki.annictforapp.view

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.wacode.yuki.annictforapp.BuildConfig
import com.wacode.yuki.annictforapp.activity.OAuthActivity

class OAuthWebViewClient(val activity: OAuthActivity) : WebViewClient() {
    override fun onPageStarted(view: WebView?, url: String, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        if(url.contains(BuildConfig.REDIRECT_URL)) getAccessToken(url)
        Log.d("onPageStared",url)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("onPageFinished",url)
    }

    private fun getAccessToken(url:String){
        val code =url.split("=")
        activity.getAccessToken(code[(code.size-1)])
    }
}