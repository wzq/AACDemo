package com.wzq.aac.data.api

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.wzq.aac.model.UserResult
import com.wzq.aac.utils.LiveDataCallAdapter
import com.wzq.aac.utils.TestRes
import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    @GET("http://132.232.98.141/users")
    fun allUser(): LiveData<TestRes<UserResult>>

    @GET("users")
    fun findUser(@Query("id")id: Int): LiveData<JsonObject>

    @POST("users")
    fun addUser(@Body params: JsonObject): LiveData<JsonObject>

    @DELETE("users")
    fun deleteUser(@Query("id")id: Int): LiveData<JsonObject>

    @PUT("users")
    fun updateUser(@Body params: JsonObject): LiveData<JsonObject>
}