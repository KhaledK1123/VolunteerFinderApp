package com.ex.volunteerfinder.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ex.volunteerfinder.model.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun fetchAllUsers():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user where name =:name")
    suspend fun deleteUserByName(name:String)
}