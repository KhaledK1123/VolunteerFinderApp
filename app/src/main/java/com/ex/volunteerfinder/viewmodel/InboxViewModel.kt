package com.ex.volunteerfinder.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.volunteerfinder.model.data.model.Conversation
import com.ex.volunteerfinder.model.data.network.RetrofitInstance
import com.ex.volunteerfinder.model.data.repository.ConversationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InboxViewModel(): ViewModel() {

    private val apiService = RetrofitInstance.volunteerApi

    var conversations:List<Conversation> by mutableStateOf(listOf())

    lateinit var clickedItem: Conversation

    init {
        fetchConversations()
    }

    fun fetchConversations() {
        var repository = ConversationRepository(apiService)
        viewModelScope.launch(Dispatchers.IO) {
            var response = repository.fetchConversations()
            when (response) {
                is ConversationRepository.Result.Success -> {
                    Log.d("ConversationViewModel", "Success")
                    conversations = response.conversationList
                }
                is ConversationRepository.Result.Failure -> {
                    Log.d("ConversationViewModel", "Failure")
                }
            }
        }


    }

    fun itemClicked(item:Conversation)
    {
        clickedItem=item
    }
}