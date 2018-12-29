package com.wzq.aac.data.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface UserApi {

    @GET("users")
    fun allUser(): Call<JsonObject>

    @GET("users")
    fun findUser(@Query("id")id: Int): Call<JsonObject>

    @POST("users")
    fun addUser(@Body params: JsonObject): Call<JsonObject>

    @DELETE("users")
    fun deleteUser(@Query("id")id: Int): Call<JsonObject>

    @PUT("users")
    fun updateUser(@Body params: JsonObject): Call<JsonObject>
}