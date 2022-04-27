package com.ex.volunteerfinder.model.data.repository

import android.util.Log
import com.ex.volunteerfinder.model.data.model.Conversation
import com.ex.volunteerfinder.model.data.network.VolunteerApi

class ConversationRepository (private val volunteerApi: VolunteerApi) {

    sealed class Result{
        data class Success(val conversationList:List<Conversation>):Result()
        data class Failure(val throwable: Throwable):Result()
    }
    suspend fun fetchConversations():Result
    {
        return try {
            val conversationList = volunteerApi.getConversations()
            Log.d("ConversationList", "Success, size of " + conversationList.size)
            Result.Success(conversationList = conversationList)
        } catch (exception:Exception)
        {
            Log.d("ConversationList","Failure")
            Result.Failure(exception)
        }
    }
}