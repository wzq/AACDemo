package com.wzq.aac

import java.util.concurrent.Executor
import java.util.concurrent.Executors

object ThreadUtils {

    private val initIO: Executor

    init {
        initIO = Executors.newSingleThreadExecutor()
    }

    fun getInitIo(): Executor {
        return initIO
    }
}