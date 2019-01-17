package com.wzq.aac.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class PersistenceWorker(val context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            //todo
            Result.success()
        }catch (ex: Exception) {
            Result.failure()
        }
    }
}