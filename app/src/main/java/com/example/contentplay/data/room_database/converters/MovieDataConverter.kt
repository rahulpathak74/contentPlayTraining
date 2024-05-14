package com.example.contentplay.data.room_database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieDataConverter {
    @TypeConverter
    fun fromListToString(dataList: List<String>): String? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {
        }.type
        return gson.toJson(dataList, type)
    }

    @TypeConverter
    fun toListFromString(dataString: String): List<String>? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {
        }.type
        return gson.fromJson<List<String>>(dataString,type)
    }
}