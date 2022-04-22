package com.ex.volunteerfinder.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ex.volunteerfinder.dao.UserDao

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getUserDatabase(context: Context):UserDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,UserDatabase::class.java,
                    "user_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}