package com.ex.volunteerfinder.widgets

import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ex.volunteerfinder.viewmodel.EventViewModel
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.model.data.Event


@Composable
fun EventList() {

//    val eventViewModel = EventViewModel(Application())
//    val eventList = eventViewModel.fetchAllEvents().observeAsState(arrayListOf())
    val eventList = arrayListOf<Event>()

    Scaffold (modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                text = {
                       Text(text = "Event",color = Color.Black)

            }, onClick = {
                // this should be for the event view model
                }
            )
        },
        content = {
            LazyColumn(content = {
                items(
                    items = eventList,
                    itemContent = {event->
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),content = {
                                 //color
//                                    Box (
//                                        content = {
//                                           Text(text = (event.name ?: "")[0].titlecase(),
//                                               fontSize = 24.sp
//                                           )
//                                        }
//                                    )
                                //not sure if I need a Box

                                //Meant to set the event
                                Column (
                                    modifier = Modifier.weight(2F),
                                    content = {
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = event.name?:"")
                                        Text(text = "${event.address}")
                                        Text(text = "${event.sponsor}")
                                    }
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                                Icon(imageVector = Icons.Default.Delete,
                                    contentDescription = "image",
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(onClick = {
                                            //eventViewModel.deleteEventById(event.id)
                                        })
                                )
                            }

                        )
                    }
                )
            })
        }
        
        )
}