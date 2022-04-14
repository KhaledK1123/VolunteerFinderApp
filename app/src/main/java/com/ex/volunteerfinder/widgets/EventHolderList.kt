package com.ex.volunteerfinder.widgets

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.ex.volunteerfinder.viewmodels.EventViewModel

@Composable
fun EventList(eventViewModel: EventViewModel){

    val eventList = eventViewModel.fetchAllEvents().observeAsState(arrayListOf())

    Scaffold {

    }
}