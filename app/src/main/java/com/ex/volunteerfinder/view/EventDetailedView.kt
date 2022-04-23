package com.ex.volunteerfinder.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.EventListScreen
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.CardMessage
import com.ex.volunteerfinder.model.MessageButton
import com.ex.volunteerfinder.view.ui.theme.Shapes
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel

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
                    title = { Text("Event Details") })
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