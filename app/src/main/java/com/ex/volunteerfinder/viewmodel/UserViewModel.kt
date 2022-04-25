package com.ex.volunteerfinder.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(app:Application):AndroidViewModel(app) {

    private val userRepository:UserRepository = UserRepository(app)

    fun fetchAllUsers():LiveData<List<User>>
    {
        return userRepository.readAllUsers
    }

    fun insertUser(user: User)
    {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    fun deleteUserByName(name:String){
        viewModelScope.launch {
            userRepository.deleteUserByName(name)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }
}