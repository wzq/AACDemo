package com.wzq.aac.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wzq.aac.ThreadUtils
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.Order

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _data = MutableLiveData<List<Order>>()

    val data: LiveData<List<Order>> get() = _data


    fun getOrders(context: Context){
        ThreadUtils.getInitIO().execute {
            _data.value = AppDatabase.getInstance(context).getOrderDao().findOrders()
        }
    }
}
