package com.wzq.aac.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.wzq.aac.database.AppDatabase
import com.wzq.aac.database.Order
import com.wzq.aac.database.OrderRepository
import java.lang.Exception

class InitDataWorker(val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        return try {
            val t = MutableList(5) { it ->
                Order(it, "o-$it", "address~~$it")
            }
            OrderRepository.getInstance(AppDatabase.getInstance(context).getOrderDao()).addOrder(t)

            Result.SUCCESS
        }catch (ex: Exception) {
            Result.FAILURE
        }
    }
}