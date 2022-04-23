package com.ex.volunteerfinder.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.dao.EventDao
import com.ex.volunteerfinder.model.data.AppDatabase
import com.ex.volunteerfinder.model.data.MyEvent

class EventRepository(application: Application) {

    var eventDao: EventDao
    init {
        var database = AppDatabase.getDatabase(application)
        eventDao = database.eventDao()
    }
    val readAllEvents:LiveData<List<MyEvent>> = eventDao.fetchAllEvents()


//    suspend fun readOneEvent(id:Int){
//        eventDao.fetchOneEvent(id)
//    }
    suspend fun deleteEventById(id:Int){
        eventDao.deleteEventById(id)
    }

    suspend fun insertEvent(event: MyEvent){
        eventDao.insertEvent(event)
    }
}