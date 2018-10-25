package com.wzq.aac

import java.util.concurrent.Executor
import java.util.concurrent.Executors

object ThreadUtils {

    private val initIO: Executor

    private val netIO: Executor

    init {
        initIO = Executors.newSingleThreadExecutor()
        netIO = Executors.newFixedThreadPool(3)
    }

    fun getInitIO(): Executor {
        return initIO
    }

    fun getNetIO(): Executor {
        return netIO
    }
}