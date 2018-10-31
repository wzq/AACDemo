package com.wzq.aac.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wzq.aac.api.NewsApi
import com.wzq.aac.model.NewsResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(val api: NewsApi){

    fun getLastNews(): LiveData<NewsResult>{
        val data: MutableLiveData<NewsResult> = MutableLiveData()
        Thread{
            Thread.sleep(1000)
            api.lastNews().enqueue(object : Callback<NewsResult>{
                override fun onResponse(call: Call<NewsResult>, response: Response<NewsResult>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<NewsResult>, t: Throwable) {
                }

            })
        }.start()


        return data
    }
}