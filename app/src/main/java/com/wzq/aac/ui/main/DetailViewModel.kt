package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.database.NewsRepository
import com.wzq.aac.model.DetailResult
import com.wzq.aac.model.News
import com.wzq.aac.model.NewsResult

class DetailViewModel internal constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getDetail(id: Int): LiveData<DetailResult> {
        return newsRepository.getNewsDetail(id)
    }

}
