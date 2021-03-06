package com.ex.volunteerfinder.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(appObj:Application): AndroidViewModel(Application()) {

    private val eventRepository: EventRepository = EventRepository(appObj)

    fun fetchAllEvents():LiveData<List<MyEvent>>
    {
        return eventRepository.readAllEvents
    }

//    suspend fun fetchOneEvent(id:Int)
//    {
//        return eventRepository.readOneEvent(id)
//    }

    fun insertEvent(event: MyEvent){

        viewModelScope.launch {
            eventRepository.insertEvent(event)
        }
    }

    fun deleteEventById(id:Int){
        viewModelScope.launch {
            eventRepository.deleteEventById(id)
        }
    }
}