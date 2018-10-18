package com.wzq.aac.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
        @PrimaryKey
        val id: Int,

        @ColumnInfo(name = "order_name")
        val name: String,

        @ColumnInfo(name = "order_address")
        val address: String
)