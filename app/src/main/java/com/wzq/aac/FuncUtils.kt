package com.wzq.aac

import java.util.concurrent.Executors

private val IO_THREAD = Executors.newSingleThreadExecutor()

fun runInIOThread(f: ()->Unit) {
    IO_THREAD.execute(f)
}