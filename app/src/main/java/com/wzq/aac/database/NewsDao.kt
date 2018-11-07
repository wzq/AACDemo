package com.wzq.aac.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wzq.aac.model.News

@Dao
interface NewsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE) //替换重复主键
    fun addNews(list: List<News>?)

    @Query("SELECT * FROM news ORDER BY id DESC")
    fun getAllNews(): LiveData<List<News>?>
}