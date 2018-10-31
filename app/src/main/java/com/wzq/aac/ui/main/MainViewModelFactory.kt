package com.wzq.aac.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wzq.aac.database.NewsRepository
import com.wzq.aac.database.OrderRepository

class MainViewModelFactory(private val repository: OrderRepository, private val np: NewsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository, np) as T
    }
}