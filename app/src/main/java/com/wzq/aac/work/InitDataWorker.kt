package com.wzq.aac.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.Order
import java.lang.Exception

class InitDataWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            val data = MutableList(10) { index ->
                Order(index, "o-$index", "address~~$index")
            }
            val od = AppDatabase.getInstance(applicationContext).getOrderDao()
            od.addOrders(data)
            Result.SUCCESS
        }catch (ex: Exception) {
            Result.FAILURE
        }
    }
}