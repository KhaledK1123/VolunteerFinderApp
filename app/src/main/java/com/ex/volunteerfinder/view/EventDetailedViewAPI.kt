package com.ex.volunteerfinder.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.EventList
import com.ex.volunteerfinder.view.ui.ApiEvents
import com.ex.volunteerfinder.view.ui.composables.ApiEvent
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.ApiEventViewModel

class EventDetailedViewAPI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val bundle = intent.extras
//        val id = bundle!!.getInt("id")
//        val name = bundle.getString("name")
//        val sponsor = bundle.getString("sponsor")
//        val leader = bundle.getString("leadership")
//        val address = bundle.getString("address")
//        val city = bundle.getString("city")
//        val zip = bundle.getInt("zip")
//        val state = bundle.getString("state")
//        val time = bundle.getString("time")
//        val date = bundle.getString("date")
        //val description = bundle.getString("description")
        val apiEventViewModel by viewModels<ApiEventViewModel>()

        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventDetailedViewAPIScreen(apiEventViewModel)
                }
            }
        }
    }
}

@Composable
fun EventDetailedViewAPIScreen(apiEventViewModel:ApiEventViewModel)
{
    var events = apiEventViewModel.events
    var listLength = events.size

    VolunteerFinderAppTheme() {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = { Text("Event Details") },
                    navigationIcon =
                    {
                        val context = LocalContext.current
                        IconButton(onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    ApiEvents::class.java
                                )
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.background
            ) {
                Column(
                    modifier = Modifier
                        .border(border = BorderStroke(1.dp, MaterialTheme.colors.primary))
                        .fillMaxWidth(.95f)
                ) {

                    LazyColumn {
                        items(listLength) {
                                index ->
                            //ApiEvent(events[index])
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Name: " + events[index].name, modifier = Modifier
                                .fillMaxWidth(.95f)
                                .padding(start = 2.dp))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Sponsor: " + events[index].sponsor, modifier = Modifier
                                .fillMaxWidth(.95f)
                                .padding(start = 2.dp))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Address: " + events[index].address + ", " + events[index].city + ", " + events[index].zipCode, modifier = Modifier
                                .fillMaxWidth(.95f)
                                .padding(start = 2.dp))
                            Spacer(modifier = Modifier.height(10.dp))
                            var i = 0
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Members List: ")
                            while( i < events[index].members.size) {
                                Text(text = events[index].members[i], modifier = Modifier
                                    .fillMaxWidth(.95f)
                                    .padding(start = 2.dp))
                                i += 1
                            }
                            i=0
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Leaders: ", modifier = Modifier
                                .fillMaxWidth(.95f)
                                .padding(start = 2.dp))
                            while( i < events[index].leadership.size) {
                                Text(text = events[index].leadership[i], modifier = Modifier
                                    .fillMaxWidth(.95f)
                                    .padding(start = 2.dp))
                                i += 1
                            }
                            i=0

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Posts: ", modifier = Modifier
                                .fillMaxWidth(.95f)
                                .padding(start = 2.dp))
                            while( i < events[index].posts.size) {
                                Text(text = events[index].posts[i].body , modifier = Modifier
                                    .fillMaxWidth(.95f)
                                    .padding(start = 2.dp))
                                Text(text = "From: " + events[index].posts[i].user, modifier = Modifier
                                    .fillMaxWidth(.95f)
                                    .padding(start = 2.dp))
                                Spacer(modifier = Modifier.height(10.dp))
                                i += 1
                            }
                            Spacer(modifier = Modifier.height(10.dp))

                        }
                    }
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(
//                        text = "Name: $name",
//                        modifier = Modifier.fillMaxWidth(.95f).padding(start = 2.dp)
//                    )
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(
//                        text = "Leader: $leader",
//                        modifier = Modifier.fillMaxWidth(.95f).padding(start = 2.dp)
//                    )
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(
//                        text = "Sponsor: $sponsor",
//                        modifier = Modifier.fillMaxWidth(.95f).padding(start = 2.dp)
//                    )
//                    Spacer(modifier = Modifier.height(10.dp))
//                }
                }
            }
        }
    }
}