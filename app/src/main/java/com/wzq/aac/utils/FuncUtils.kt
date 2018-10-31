package com.wzq.aac.utils

import android.content.Context
import com.wzq.aac.api.NewsApi
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.NewsRepository
import com.wzq.aac.database.OrderRepository
import com.wzq.aac.ui.main.MainViewModelFactory
import java.util.concurrent.Executors

private val IO_THREAD = Executors.newSingleThreadExecutor()

fun runInIOThread(f: ()->Unit) {
    IO_THREAD.execute(f)
}

private val NEWS_API by lazy { NewsApi.create() }

fun getNewsApi(): NewsApi {
    return NEWS_API
}


fun getFactory(context: Context): MainViewModelFactory {
    val o = OrderRepository.getInstance(AppDatabase.getInstance(context).getOrderDao())
    val n = NewsRepository(getNewsApi())
    return MainViewModelFactory(o, n)
}