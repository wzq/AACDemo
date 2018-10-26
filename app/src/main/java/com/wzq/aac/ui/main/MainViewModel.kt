package com.wzq.aac.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.database.Order
import com.wzq.aac.database.OrderRepository

class MainViewModel internal constructor(repository: OrderRepository): ViewModel() {
    // TODO: Implement the ViewModel

    private val orders = MediatorLiveData<List<Order>>().apply { value = null }

    init {

        val listResult = repository.getOrders()

        orders.addSource(listResult, orders::setValue)
    }

    fun getOrders() = orders
}
