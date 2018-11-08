package com.wzq.aac.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun list2json(list: List<String>?): String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun json2list(str: String?): List<String>{
        return Gson().fromJson(str, Array<String> :: class.java).toList()
    }
}