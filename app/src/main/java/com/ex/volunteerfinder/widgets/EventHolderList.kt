package com.ex.volunteerfinder.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ex.volunteerfinder.viewmodels.EventViewModel

@Composable
fun EventList(eventViewModel: EventViewModel){

    val eventList = eventViewModel.fetchAllEvents().observeAsState(arrayListOf())

    Scaffold (modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                text = {
                       Text(text = "Event",color = Color.Black)

            }, onClick = {

                })
        }
        
        ) {

    }
}