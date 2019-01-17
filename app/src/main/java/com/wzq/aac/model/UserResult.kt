package com.wzq.aac.model

data class UserResult(
        val status: String,
        val message: String,
        val data: List<User>
)