package com.wacode.yuki.annictforapp.rest

import com.wacode.yuki.annictforapp.rest.entity.WorksEntity
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by yuki on 2016/09/26.
 */
interface WorksApiService {
    @GET("/v1/works")
    fun getWorks(@QueryMap queryMap: Map<String,String>):Observable<WorksEntity>

    @GET("/v1/me/works")
    fun getMeWorks(@QueryMap queryMap: Map<String, String>):Observable<WorksEntity>
}