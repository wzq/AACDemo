package com.wzq.aac.data.api

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.wzq.aac.model.User
import com.wzq.aac.model.UserResult
import retrofit2.http.*

interface UserApi {

    @GET("http://132.232.98.141/users")
    fun allUser(): LiveData<UserResult>

    @GET("http://132.232.98.141/users")
    fun findUser(@Query("id")id: Int): LiveData<User>

    @POST("users")
    fun addUser(@Body params: JsonObject): LiveData<JsonObject>

    @DELETE("users")
    fun deleteUser(@Query("id")id: Int): LiveData<JsonObject>

    @PUT("users")
    fun updateUser(@Body params: JsonObject): LiveData<JsonObject>
}