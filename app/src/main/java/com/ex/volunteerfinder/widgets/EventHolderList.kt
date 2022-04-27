package com.ex.volunteerfinder.widgets

import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.ex.volunteerfinder.viewmodel.EventViewModel
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.CreateNewEvent
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.view.EventDetailedView
import com.ex.volunteerfinder.view.ui.RoundImage


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
                // this goes to the Create New Event page
                context.startActivity(Intent(context, CreateNewEvent::class.java))
                },icon = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "image", tint = Color.White)
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
                                .fillMaxHeight()
                                .padding(horizontal = 8.dp, vertical = 8.dp),content = {
                                 //color
                                    Box (
                                        content = {
                                           RoundImage(painterResource(id = R.drawable.blankpfp))
                                        }, modifier = Modifier
                                            .size(80.dp)
                                            .padding(10.dp)
                                            .border(
                                                width = 1.2.dp,
                                                color = MaterialTheme.colors.primaryVariant,
                                                shape = CircleShape
                                            ),
                                        contentAlignment = Alignment.Center
                                    )
                                //not sure if I need a Box

                                //Meant to set the event
                                val context = LocalContext.current
                                Column (

                                    modifier = Modifier
                                        .weight(2F)
                                        .clickable(onClick = {
                                            context.startActivity(Intent(context,EventDetailedView::class.java)
                                                .putExtra("id", event.id)
                                                .putExtra("address", event.address)
                                                .putExtra("city", event.city)
                                                .putExtra("date", event.date)
                                                .putExtra("leadership", event.leadership)
                                                .putExtra("name", event.name)
                                                .putExtra("sponsor", event.sponsor)
                                                .putExtra("state", event.state)
                                                .putExtra("time", event.time)
                                                .putExtra("zip", event.zipCode))
                                                //.putExtra("description", event.description))
                                        }),
                                    content = {
                                        Spacer(modifier = Modifier.size(8.dp))
                                        Text(text = "Event: " + event.name?:"")
                                        when {
                                            event.zipCode!! <10 -> {
                                                Text(text = "Address: " + "${event.address} " +"${event.city}, " +"${event.state} "+"0000${event.zipCode}")
                                            }
                                            event.zipCode!!<100 -> {
                                                Text(text = "Address: " + "${event.address} " +"${event.city}, " +"${event.state} "+"000${event.zipCode}")
                                            }
                                            event.zipCode!!<1000 -> {
                                                Text(text = "Address: " + "${event.address} " +"${event.city}, " +"${event.state} "+"00${event.zipCode}")
                                            }
                                            event.zipCode!!<10000 -> {
                                                Text(text = "Address: " + "${event.address} " +"${event.city}, " +"${event.state} "+"0${event.zipCode}")
                                            }
                                            else -> {
                                                Text(text = "Address: " + "${event.address} " +"${event.city}, " +"${event.state} "+"${event.zipCode}")
                                            }
                                        }
                                        Text(text = "Leader: " + "${event.leadership}")
                                        Text(text = "Sponsor: " + "${event.sponsor}")
                                        Text(text = "Date: " + "${event.date} " + "Time: " + "${event.time}")
                                        //Insert clickeable hypertext from Login but redirect it to edit event
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