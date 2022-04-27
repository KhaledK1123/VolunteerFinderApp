package com.ex.volunteerfinder.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex.volunteerfinder.model.data.model.ApiEvent
import com.ex.volunteerfinder.model.data.network.RetrofitInstance
import com.ex.volunteerfinder.model.data.repository.OrgEventRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiEventViewModel(): ViewModel() {

    private val apiService = RetrofitInstance.volunteerApi

    var events:List<ApiEvent> by mutableStateOf(listOf())

    init {
        fetchEvents()
    }

    fun fetchEvents() {

        var repository = OrgEventRepository(apiService)
        viewModelScope.launch(Dispatchers.IO) {
            var response = repository.fetchEvents()
            when (response) {
                is OrgEventRepository.Result.Success ->
                {
                    Log.d("EventViewModel", "Success")
                    events = response.eventList
                }
                is OrgEventRepository.Result.Failure ->
                {
                    Log.d("EventViewModel", "Failure")
                }
            }
        }
    }
}