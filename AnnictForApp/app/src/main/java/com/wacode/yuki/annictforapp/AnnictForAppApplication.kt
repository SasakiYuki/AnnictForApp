package com.wacode.yuki.annictforapp

import android.accessibilityservice.AccessibilityService
import android.app.Application
import android.util.Log
import com.wacode.yuki.annictforapp.rest.OAuthAPIService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by yuki on 2016/09/26.
 */
class AnnictForAppApplication :Application(){
    private val logging = HttpLoggingInterceptor({Log.d("API_LOG",it)}).setLevel(HttpLoggingInterceptor.Level.BASIC)
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()
    private lateinit var accessTokenService:OAuthAPIService
    override fun onCreate() {
        super.onCreate()
        setupApiClient()
    }

    private fun setupApiClient(){
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(AppConfig.getApiEndpoint())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        accessTokenService = retrofit.create(OAuthAPIService::class.java)
    }

    fun getOAuthApiService() = accessTokenService

}