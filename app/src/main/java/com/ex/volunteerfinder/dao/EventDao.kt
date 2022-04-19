package com.ex.volunteerfinder.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ex.volunteerfinder.model.data.MyEvent


@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun fetchAllEvents():LiveData<List<MyEvent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: MyEvent)

    @Query("DELETE FROM event where id=:id")
    suspend fun deleteEventById(id:Int)
}