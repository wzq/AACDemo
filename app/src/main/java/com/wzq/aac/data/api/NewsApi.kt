package com.wzq.aac.data.api

import com.wzq.aac.model.DetailExtra
import com.wzq.aac.model.DetailResult
import com.wzq.aac.model.NewsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    @GET("news/latest")
    fun lastNews(): Call<NewsResult>

    @GET("news/before/{date}")
    fun oldNews(@Path("date") date: String): Call<NewsResult>

    @GET("story-extra/{id}")
    fun stars(@Path("id") id: Int): Call<DetailExtra>

    @GET("https://zhihu-daily.leanapp.cn/api/v1/contents/{id}")
    fun newsDetail(@Path("id") id: Int): Call<DetailResult>
}