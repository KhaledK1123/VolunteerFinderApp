package com.ex.volunteerfinder.model.data.repository

import android.util.Log
import com.ex.volunteerfinder.model.data.model.ApiEvent
import com.ex.volunteerfinder.model.data.network.VolunteerApi

class OrgEventRepository (private val volunteerApi: VolunteerApi) {

    sealed class Result{
        data class Success(val eventList:List<ApiEvent>):Result()
        data class Failure(val throwable: Throwable):Result()
    }
    suspend fun fetchEvents():Result
    {
        return try {
            val eventList = volunteerApi.getEvents()
            Log.d("EventList", "Success, size of " + eventList.size)
            Result.Success(eventList = eventList)
        } catch (exception:Exception)
        {
            Log.d("EventList","Failure")
            Result.Failure(exception)
        }
    }
}