package com.ex.volunteerfinder.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ex.volunteerfinder.dao.EventDao


@Database(entities = [MyEvent::class],version = 2,exportSchema = false)
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
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

    }

}