package com.ex.volunteerfinder.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ex.volunteerfinder.model.data.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun fetchAllUsers():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update(User::class)
    suspend fun updateUser(vararg user: User)

    @Query("DELETE FROM user where id =:id")
    suspend fun deleteUser(id:Int)
}