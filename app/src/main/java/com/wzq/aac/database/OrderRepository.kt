package com.wzq.aac.database

class OrderRepository private constructor(private val orderDao: OrderDao){

    fun getOrders() = orderDao.findOrders()

    fun addOrder(orders:List<Order>) = orderDao.addOrders(orders)

    companion object {
        @Volatile private var instance: OrderRepository? = null

        fun getInstance(orderDao: OrderDao) =
            instance ?: synchronized(this) {
                instance ?: OrderRepository(orderDao).also { instance = it }
            }

    }
}