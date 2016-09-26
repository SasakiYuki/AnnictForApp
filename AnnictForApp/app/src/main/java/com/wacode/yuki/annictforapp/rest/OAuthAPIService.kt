package com.wacode.yuki.annictforapp.rest

import com.wacode.yuki.annictforapp.rest.entity.OAuthEntity
import retrofit2.http.POST
import retrofit2.http.QueryMap
import rx.Observable

interface OAuthAPIService {
    @POST("/oauth/token")
    fun getAccessToken(@QueryMap queryMap: Map<String, String>): Observable<OAuthEntity>
}