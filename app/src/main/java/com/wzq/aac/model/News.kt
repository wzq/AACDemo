package com.wzq.aac.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class News(
        val title: String,

//        @Ignore //should save as json by converters
        val images: List<String>,

        @PrimaryKey
        val id: Int
)