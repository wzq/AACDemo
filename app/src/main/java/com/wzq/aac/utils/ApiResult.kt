package com.wzq.aac.utils

import retrofit2.Response

class ApiResult<T> {
    companion object {
        fun <T> create(res: Response<T>){

        }

        fun <T> create(throwable: Throwable) {

        }
    }

}