package com.ex.volunteerfinder.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.model.data.AppDatabase
import com.ex.volunteerfinder.model.data.MyEvent

class ForgotPasswordRepository(application: Application) {
/*
    lateinit var forgotPasswordDao: ForgotPasswordDao
    init {
        var database = AppDatabase.getDatabase(application)
        forgotPasswordDao = database.forgotPasswordDao()
    }
    val readAllForgotPasswords: LiveData<List<MyForgotPassword>>
        = forgotPasswordDao.fetchAllForgotPasswords
Commented out, until data class is created (perhaps 'MyPassword' ??); perhaps need a name change, to
 THIS class (i.e., 'PasswordRepository') */

}

