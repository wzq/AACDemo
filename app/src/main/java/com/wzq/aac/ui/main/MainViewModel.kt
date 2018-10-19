package com.wzq.aac.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.database.AppDatabase

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _data = MutableLiveData<User>()

    val data: LiveData<User> get() = _data

    init {
        _data.value = User(1, "wzq", 22)
    }

    fun change(){
        _data.value = User(2, "qzw", 33)
    }


    fun getOrders(){
    }
}
