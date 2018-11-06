package com.wzq.aac.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wzq.aac.api.NewsApi
import com.wzq.aac.model.DetailResult
import com.wzq.aac.model.NewsDetail
import com.wzq.aac.model.NewsResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(val api: NewsApi) {

    fun getLastNews(): LiveData<NewsResult> {
        val data: MutableLiveData<NewsResult> = MutableLiveData()
        api.lastNews().enqueue(resultFactory<NewsResult> {
            data.value = it
        })
        return data
    }



    fun getNewsDetail(id: Int): LiveData<DetailResult>{
        val data: MutableLiveData<DetailResult> = MutableLiveData()
        api.newsDetail(id).enqueue(resultFactory {
            data.value = it
        })
        return data

    }

    private fun <T> resultFactory(action: (T?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                action(response.body())
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
            }

        }
    }
}