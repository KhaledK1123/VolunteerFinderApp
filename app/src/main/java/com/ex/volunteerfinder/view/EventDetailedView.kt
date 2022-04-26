package com.ex.volunteerfinder.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.EventList
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.MessageButton
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.view.ui.theme.background


class EventDetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        val id = bundle!!.getInt("id")
        val name = bundle.getString("name")
        val sponsor = bundle.getString("sponsor")
        val leader = bundle.getString("leadership")
        val address = bundle.getString("address")
        val city = bundle.getString("city")
        val zip = bundle.getInt("zip")
        val state = bundle.getString("state")
        val time = bundle.getString("time")
        val date = bundle.getString("date")
        //val description = bundle.getString("description")


        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventDetailedViewScreen(id, name, sponsor, leader, address, city, zip, state, time, date)
                }
            }
        }
    }
}

@Composable
fun EventDetailedViewScreen(id:Int, name:String?, sponsor:String?, leader:String?, address:String?, city:String?, zip:Int, state:String?, time:String?, date:String?) {
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
                    Column(
                        modifier = Modifier.border(border = BorderStroke(2.dp,MaterialTheme.colors.primary))
                            .fillMaxWidth(3f)
                    ) {
                        //val intent: Intent = getIntentOld("EventList")
                        //val message: String = intent.getStringExtra(MainActivity().EXTRA_MESSAGE)
                        //val ss:String = intent.getStringExtra("id").toString()
                        //val bundle:Bundle ?= intent.extras
                        //val id:String = bundle?.get("id") as String
                        //Text(text = "1$id")
                        //Text(text = "2$message")
                        //CardMessage()
                        //EventLister()

                        //Old Format-------------------------------------------------------------
//                        Text(text = "Name: $name")
//                        Text(text = "Address: $address, $city, $state, $zip")
//                        //Text(text = "name: $city")
//                        Text(text = "Leader: $leader")
////                        Text(text = "name: $")
////                        Text(text = "name: $name")
////                        Text(text = "name: $name")
//                        Text(text = "Sponsor: $sponsor")
//                        Text(text = "Date: $date")
//                        Text(text = "Time: $time")

                        //New Format--------------------------------------------
                        Text(text = "Name: $name")
                        when {
                            zip <10 -> {
                                Text(text = "Address: " + "$address " +"$city, " +"$state "+"0000${zip}")
                            }
                            zip<100 -> {
                                Text(text = "Address: " + "$address " +"$city, " +"$state "+"000${zip}")
                            }
                            zip<1000 -> {
                                Text(text = "Address: " + "$address " +"$city, " +"$state "+"00${zip}")
                            }
                            zip<10000 -> {
                                Text(text = "Address: " + "$address " +"$city, " +"$state "+"0${zip}")
                            }
                            else -> {
                                Text(text = "Address: $address, $city, $state $zip")
                            }
                        }
                        Text(text = "Leader: $leader")
                        Text(text = "Sponsor: $sponsor")
                        Text(text = "Date: $date Time: $time")

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
@Composable
fun CardMessage() {
    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(10.dp),
        backgroundColor = background,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colors.primaryVariant
        )
    ) {

        //.fillMaxWidth()
        Column(
            modifier = Modifier.padding(100.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Message",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}