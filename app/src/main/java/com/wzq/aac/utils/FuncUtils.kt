package com.wzq.aac.utils

import android.content.Context
import com.wzq.aac.data.api.NewsApi
import com.wzq.aac.data.database.AppDatabase
import com.wzq.aac.data.NewsRepository
import com.wzq.aac.ui.main.DetailViewModelFactory
import com.wzq.aac.ui.main.MainViewModelFactory
import java.util.concurrent.Executors

private val IO_THREAD = Executors.newSingleThreadExecutor()

fun runInIOThread(f: ()->Unit) {
    IO_THREAD.execute(f)
}

fun getFactory(context: Context): MainViewModelFactory {
    val n = NewsRepository.getInstance(Linker.newsApi, AppDatabase.getInstance(context).getNewsDao())
    return MainViewModelFactory(n)
}

fun getDetailVM(context: Context): DetailViewModelFactory {
    val n = NewsRepository.getInstance(Linker.newsApi, AppDatabase.getInstance(context).getNewsDao())
    return DetailViewModelFactory(n)
}