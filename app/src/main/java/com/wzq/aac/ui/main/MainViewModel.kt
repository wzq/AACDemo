package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.data.NewsRepository
import com.wzq.aac.model.News
import com.wzq.aac.model.NewsResult

class MainViewModel internal constructor(private val newsRepository: NewsRepository) : ViewModel() {

    val news = MediatorLiveData<NewsResult>() // from web

    val dbNews: LiveData<List<News>?>

    init {
        news.addSource(newsRepository.getLastNews(), news::setValue)
        dbNews = newsRepository.checkDb()
    }

}
