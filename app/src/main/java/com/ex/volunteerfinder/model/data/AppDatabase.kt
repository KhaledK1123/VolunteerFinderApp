package com.ex.volunteerfinder.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ex.volunteerfinder.dao.EventDao


@Database(entities = [MyEvent::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun eventDao():EventDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context:Context):AppDatabase{

            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,AppDatabase::class.java,
                    "event_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}