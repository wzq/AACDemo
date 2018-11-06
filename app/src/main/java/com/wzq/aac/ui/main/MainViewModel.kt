package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.database.NewsRepository
import com.wzq.aac.database.Order
import com.wzq.aac.database.OrderRepository
import com.wzq.aac.model.DetailResult
import com.wzq.aac.model.NewsDetail
import com.wzq.aac.model.NewsResult

class MainViewModel internal constructor(orderRepository: OrderRepository, val newsRepository: NewsRepository) : ViewModel() {

    val orders = MediatorLiveData<List<Order>>() //from db

    val news = MediatorLiveData<NewsResult>() // from web

    init {

        orders.addSource(orderRepository.getOrders(), orders::setValue)

        news.addSource(newsRepository.getLastNews(), news::setValue)
    }

    fun getDetail(id: Int): LiveData<DetailResult> {
        return newsRepository.getNewsDetail(id)
    }

}
