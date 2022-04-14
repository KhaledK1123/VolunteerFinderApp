package com.ex.volunteerfinder.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ex.volunteerfinder.model.data.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM customer")
    fun fetchAllEvents():LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: Event)

    @Query("DELETE FROM customer where id=:id")
    suspend fun deleteEventById(id:Int)
}