package com.wzq.aac.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OrderDao {

    @Query("select * from orders")
    fun findOrders(): LiveData<List<Order>>

    @Query("select * from orders where id = :id")
    fun findOrder(id: Int): LiveData<Order>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addOrders(orders: List<Order>)
}