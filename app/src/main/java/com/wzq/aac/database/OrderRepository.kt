package com.wzq.aac.database

class OrderRepository private constructor(private val orderDao: OrderDao){

    fun getOrders() = orderDao.findOrders()

    companion object {
        @Volatile private var instance: OrderRepository? = null

        fun getInstance(orderDao: OrderDao) =
            instance ?: synchronized(this) {
                instance ?: OrderRepository(orderDao).also { instance = it }
            }

    }
}