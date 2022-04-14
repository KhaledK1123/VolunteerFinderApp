package com.ex.volunteerfinder.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.dao.EventDao
import com.ex.volunteerfinder.model.data.AppDatabase
import com.ex.volunteerfinder.model.data.Event

class EventRepository(application: Application) {
    private lateinit var eventDao: EventDao

    init {
        var database = AppDatabase.getDatabase(application)
        eventDao = database.eventDao()
    }
    val readAllEvents:LiveData<List<Event>> = eventDao.fetchAllEvents()

    suspend fun deleteEventById(id:Int){
        eventDao.deleteEventById(id)
    }

    suspend fun insertEvent(event: Event){
        eventDao.insertEvent(event)
    }
}