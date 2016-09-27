package com.wacode.yuki.annictforapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import butterknife.bindView
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import com.wacode.yuki.annictforapp.AnnictForAppApplication
import com.wacode.yuki.annictforapp.utils.OAuth.OAuthHelper
import com.wacode.yuki.annictforapp.view.OAuthWebViewClient
import com.wacode.yuki.annictforapp.R
import com.wacode.yuki.annictforapp.contract.AccessTokenContract
import com.wacode.yuki.annictforapp.utils.PrefManager
import com.wacode.yuki.annictforapp.viewmodel.AccessTokenViewModel

class OAuthActivity : RxAppCompatActivity(), AccessTokenContract.AccessTokenView {
    private val webView by bindView<WebView>(R.id.activity_oauth_web)
    private lateinit var viewModel: AccessTokenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth)
        viewModel = AccessTokenViewModel((application as AnnictForAppApplication).getOAuthApiService())
        viewModel.setView(this)
        webView.setWebViewClient(OAuthWebViewClient(this))
        webView.loadUrl(OAuthHelper.builder)
    }

    fun getAccessToken(code:String){
        viewModel.getAccessToken(code)
    }

    override fun storeAccessToken(accessToken: String) {
        PrefManager(this).setAccessToken(accessToken)
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun showError() {
        Log.d("eeror","error")
    }
}
