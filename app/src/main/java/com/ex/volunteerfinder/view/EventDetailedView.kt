package com.ex.volunteerfinder.view

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.EventList
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.CardMessage
import com.ex.volunteerfinder.model.MessageButton
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme


class EventDetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val id = intent.getIntExtra("id", 0)
                    EventDetailedViewScreen(id)
                }
            }
        }
    }
}
@Composable
fun EventDetailedViewScreen() {
    VolunteerFinderAppTheme() {

        Scaffold(
            topBar = {

                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = { Text("Event Details") })
            }
        ) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

                val imgList =
                    listOf<Int>(R.drawable.mercedes, R.drawable.iphone, R.drawable.soccerevent)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .height(175.dp)
                            .border(2.dp, MaterialTheme.colors.primary)


                    ) {
                        LazyRow {
                            items(imgList.size) { index ->
                                //Text(text = donation.images[index])
                                Image(
                                    painter = painterResource(id = imgList[index]),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(250.dp)
                                        .padding(8.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }

                        //Image(painterResource(R.drawable.soccerevent), "content description")
                    }
                    Column() {
                        CardMessage()
                        //EventLister()
                    }

                    Row(
                        Modifier
                            .padding(bottom = 55.dp)
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        //JoinButton()
                        MessageButton()
                    }
                }
            }
        }
    }
}

@Composable
fun EventDetailedViewScreen(id:Int) {
    VolunteerFinderAppTheme() {

        Scaffold(
            topBar = {

                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = { Text("Event Details") },
                    navigationIcon =
                    {
                        val context = LocalContext.current
                        IconButton(onClick = { context.startActivity(Intent(context, EventList::class.java)) }) {
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
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                //val event = eventViewModel.fetchOneEvent().observeAsState(arrayListOf())
                val imgList =
                    listOf<Int>(R.drawable.mercedes, R.drawable.iphone, R.drawable.soccerevent)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .height(175.dp)
                            .border(2.dp, MaterialTheme.colors.primary)


                    ) {
                        LazyRow {
                            items(imgList.size) { index ->
                                //Text(text = donation.images[index])
                                Image(
                                    painter = painterResource(id = imgList[index]),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(250.dp)
                                        .padding(8.dp),
                                    contentScale = ContentScale.Fit
                                )
                            }
                        }

                        //Image(painterResource(R.drawable.soccerevent), "content description")
                    }
                    Column() {
                        //val intent: Intent = getIntentOld("EventList")
                        //val message: String = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
                        //val ss:String = intent.getStringExtra("id").toString()
                        //val bundle:Bundle ?= intent.extras
                        //val id:String = bundle?.get("id") as String
                        //Text(text = "1$id")
                        //Text(text = "2$ss")
                        CardMessage()
                        //EventLister()
                    }

                    Row(
                        Modifier
                            .padding(bottom = 55.dp)
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        //JoinButton()
                        //MessageButton()
                    }
                }
            }
        }
    }
}