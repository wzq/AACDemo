package com.wzq.aac.utils

import android.content.Context
import com.wzq.aac.api.NewsApi
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.NewsRepository
import com.wzq.aac.ui.main.DetailViewModel
import com.wzq.aac.ui.main.DetailViewModelFactory
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
    val n = NewsRepository.getInstance(getNewsApi(), AppDatabase.getInstance(context).getNewsDao())
    return MainViewModelFactory(n)
}

fun getDetailVM(context: Context): DetailViewModelFactory {
    val n = NewsRepository.getInstance(getNewsApi(), AppDatabase.getInstance(context).getNewsDao())
    return DetailViewModelFactory(n)
}