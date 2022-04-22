package com.ex.volunteerfinder.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.dao.UserDao
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.model.data.UserDatabase

class UserRepository(application: Application) {

    lateinit var userDao: UserDao

    init {
        var database = UserDatabase.getUserDatabase(application)
        userDao = database.userDao()
    }
    val readAllUsers:LiveData<List<User>> =userDao.fetchAllUsers()

    suspend fun deleteUserByName(name:String){
        userDao.deleteUserByName(name)
    }

    suspend fun insertUser(user: User){
        userDao.insertUser(user)
    }
}