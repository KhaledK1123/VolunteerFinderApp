package com.ex.volunteerfinder.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.dao.EventDao
import com.ex.volunteerfinder.model.data.AppDatabase
import com.ex.volunteerfinder.model.data.MyEvent

class EventRepository(context: Context) {

    lateinit var eventDao: EventDao
    init {
        var database = AppDatabase.getDatabase(context)
        eventDao = database.eventDao()
    }
    val readAllEvents:LiveData<List<MyEvent>> = eventDao.fetchAllEvents()

    suspend fun deleteEventById(id:Int){
        eventDao.deleteEventById(id)
    }

    suspend fun insertEvent(event: MyEvent){
        eventDao.insertEvent(event)
    }
}