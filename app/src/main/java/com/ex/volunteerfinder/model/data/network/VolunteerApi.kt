package com.ex.volunteerfinder.model.data.network

import com.ex.volunteerfinder.model.data.model.ApiEvent
import com.ex.volunteerfinder.model.data.model.Conversation
import retrofit2.http.GET

interface VolunteerApi {

    @GET("/organization")
    suspend fun getEvents(): List<ApiEvent>

    @GET("/messages")
    suspend fun getConversations(): List<Conversation>

}