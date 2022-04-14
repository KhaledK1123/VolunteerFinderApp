package com.ex.volunteerfinder.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ex.volunteerfinder.model.data.Event
import com.ex.volunteerfinder.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(appObj:Application):AndroidViewModel(appObj) {

    private val eventRepository: EventRepository = EventRepository(appObj)

    fun fetchAllEvents():LiveData<List<Event>>
    {
        return eventRepository.readAllEvents
    }

    fun insertEvent(event: Event){

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