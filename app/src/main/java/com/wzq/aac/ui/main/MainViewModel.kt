package com.wzq.aac.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.database.Order
import com.wzq.aac.database.OrderRepository

class MainViewModel internal constructor(val repository: OrderRepository): ViewModel() {
    // TODO: Implement the ViewModel

    val orders = MediatorLiveData<List<Order>>()

    init {
        orders.addSource(repository.getOrders(), orders::setValue)
    }


    fun add(){

        val t = MutableList(5) { it ->
            val index = it + 20
            Order(index, "o-$index", "address~~$index")
        }
        repository.addOrder(t)
    }

}
