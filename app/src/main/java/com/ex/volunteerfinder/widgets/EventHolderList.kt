package com.ex.volunteerfinder.widgets

import android.app.Application
import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import com.ex.volunteerfinder.viewmodel.EventViewModel
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.ex.volunteerfinder.CreateNewEvent
import com.ex.volunteerfinder.MainActivity
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.view.EventDetailedView


@Composable
fun EventList(eventViewModel: EventViewModel) {

//    val eventViewModel = EventViewModel(Application())
    val eventList = eventViewModel.fetchAllEvents().observeAsState(arrayListOf())
    //val eventList = arrayListOf<MyEvent>()


    Scaffold (modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            val context = LocalContext.current
            ExtendedFloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                text = {
                       Text(text = "Event",color = Color.Black)

            }, onClick = {
                // this should be for the event view model
                context.startActivity(Intent(context, CreateNewEvent::class.java))
                }
            )
        },
        content = {
            LazyColumn(content = {
                items(
                    items = eventList.value,
                    itemContent = {event->
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),content = {
                                 //color
//                                    Box (
//                                        content = {
//                                           Text(text = (event.name ?: "")[0].titles(),
//                                               fontSize = 24.sp
//                                           )
//                                        }
//                                    )
                                //not sure if I need a Box

                                //Meant to set the event
                                val context = LocalContext.current
                                Column (

                                    modifier = Modifier
                                        .weight(2F)
                                        .clickable(onClick = {
                                            context.startActivity(Intent(context, EventDetailedView::class.java))
                                        }),
                                    content = {
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = "Name: " + event.name?:"")
                                        Text(text = "Address: " + "${event.address}")
                                        Text(text = "Leader: " + "${event.leadership}")
                                        Text(text = "Date: " + "${event.date} " + "Time: " + "${event.time}")

                                    }
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                                Icon(imageVector = Icons.Default.Delete,
                                    contentDescription = "image",
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .clickable(onClick = {
                                            eventViewModel.deleteEventById(event.id)
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