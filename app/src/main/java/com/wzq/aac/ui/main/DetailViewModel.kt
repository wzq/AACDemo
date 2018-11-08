package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.data.NewsRepository
import com.wzq.aac.model.DetailResult

class DetailViewModel internal constructor(private val newsRepository: NewsRepository) : ViewModel() {

    fun getDetail(id: Int): LiveData<DetailResult> {
        return newsRepository.getNewsDetail(id)
    }

}
