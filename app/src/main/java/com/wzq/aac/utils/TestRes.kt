package com.wzq.aac.utils

data class TestRes<T>(
        val code: Int,
        val body: T,
        val msg: String
)