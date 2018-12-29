package com.wzq.aac.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppExecutors {

    val diskIO by lazy{
        Executors.newSingleThreadExecutor()
    }

    val mainThread by lazy {
        Executor{
            Handler(Looper.getMainLooper()).post(it)
        }
    }

}