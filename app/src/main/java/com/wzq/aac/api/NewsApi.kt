package com.wzq.aac.api

import android.util.Log
import com.wzq.aac.model.DetailExtra
import com.wzq.aac.model.DetailResult
import com.wzq.aac.model.NewsDetail
import com.wzq.aac.model.NewsResult
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApi {

    @GET("news/latest")
    fun lastNews(): Call<NewsResult>

    @GET("https://news-at.zhihu.com/api/4/news/before/{date}")
    fun oldNews(@Path("date") date: String): Call<NewsResult>

    @GET("https://news-at.zhihu.com/api/4/story-extra/{id}")
    fun stars(@Path("id") id: Int): Call<DetailExtra>

    @GET("https://zhihu-daily.leanapp.cn/api/v1/contents/{id}")
    fun newsDetail(@Path("id")id: Int): Call<DetailResult>


    companion object {
        private val BASE_URL = "https://news-at.zhihu.com/api/4/"

        fun  create(): NewsApi {
            Log.i("aac", "api zcreated")

            val logger = HttpLoggingInterceptor(
                    HttpLoggingInterceptor.Logger { Log.d("API", it) }
            )
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            val url = HttpUrl.parse(BASE_URL)!!
            return Retrofit.Builder().baseUrl(url)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(NewsApi::class.java)
        }
    }
}