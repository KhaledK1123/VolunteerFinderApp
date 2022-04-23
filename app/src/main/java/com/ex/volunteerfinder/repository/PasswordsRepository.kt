package com.ex.volunteerfinder.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.model.data.AppDatabase
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.model.data.Passwords

class PasswordsRepository(application: Application) {


    lateinit var passwordsDao: PasswordsDao

    class PasswordsDao {

    }
/*
    init {
        var database = AppDatabase.getDatabase(application)
        passwordsDao = database.passwordsDao()
    }
    val readAllPasswords: LiveData<List<Passwords>>
        = passwordsDao.fetchAllPasswords

    suspend fun deletePasswordsByEmail(email:String){
        passwordsDao.deletePasswordsByEmail(email)
    }

    suspend fun insertPasswords(Passwords: Passwords){
        passwordsDao.insertPasswords(passwords)
    }
    Go over above 14 lines, BEFORE un-commenting */


}


