package com.example.contentplay.data.room_database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contentplay.data.room_database.dao.ContentPlayDAO

@Database(entities = [], version = 1, exportSchema = false)
abstract class ContentPlayDatabase: RoomDatabase(){

    abstract fun contentPlayDao(): ContentPlayDAO

    companion object {

        @Volatile
        private  var INSTANCE: ContentPlayDatabase? = null

        fun getDatabase( context: Context) : ContentPlayDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContentPlayDatabase::class.java,
                    "content_play"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}