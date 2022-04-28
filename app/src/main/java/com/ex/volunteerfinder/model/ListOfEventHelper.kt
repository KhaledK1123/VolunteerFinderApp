package com.ex.volunteerfinder.model

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.DummyDonation
import com.ex.volunteerfinder.model.data.EventImg
import com.ex.volunteerfinder.model.data.MessageDummy
import com.ex.volunteerfinder.model.data.model.Conversation
import com.ex.volunteerfinder.model.data.model.Message
import com.ex.volunteerfinder.view.CardMessage
import com.ex.volunteerfinder.view.ui.composables.ChatCollectionComposable
import com.ex.volunteerfinder.view.ui.theme.Shapes
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.view.ui.theme.background
import com.ex.volunteerfinder.viewmodel.MyEventDetails


class EventListener : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                Scaffold(
                    topBar = {

                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.primary,
                            title = {Text("Event List")})
                    }
                ) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(painterResource(R.drawable.mercedes),"content description")

                            CardMessage()
                            //EventLister()
                            var message by rememberSaveable { mutableStateOf("") }
                            TextField(
                                value = message,
                                isError = false,
                                onValueChange = { message = it },
                                label = { Text(text = "Message",
                                    style = MaterialTheme.typography.subtitle1) },
                                modifier = Modifier
                                    .padding(
                                        top = 35.dp,
                                        bottom = 25.dp,
                                        start = 15.dp,
                                        end = 15.dp
                                    )
                                    .fillMaxWidth()
                                    .clip(Shapes.medium)
                            )
                            Row (
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
    }
}

@Composable
fun EventLister(eventsImg: EventImg.EventImg)
{
    LazyColumn(Modifier.padding(47.dp)) {
        items(eventsImg.images) { eventImg ->
            eventImg
        }
    }
}


@Preview
@Composable
fun MessageButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), Arrangement.Center
        ) {
            val context = LocalContext.current
//            TextButton( modifier = Modifier.padding(horizontal = 40.dp),
//                onClick = {
//                    //context.startActivity(Intent(context, ::class.java))
//                    Toast.makeText(context, "Join!", Toast.LENGTH_SHORT).show()
//                },
//
//                ) {
//                Text("Join!",
//                    style = MaterialTheme.typography.h6,
//                    color = MaterialTheme.colors.primary)
//            }
            //val context = LocalContext.current
            TextButton(
                //modifier = Modifier.padding(horizontal = 40.dp),
                onClick = {

                    //context.startActivity(Intent(context, ::class.java))
                    Toast.makeText(context, "Message!", Toast.LENGTH_SHORT).show()
                },

                ) {
                Text("Message Event Members!",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary)
            }
        }


    }

}

@Composable
fun JoinButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.Start
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                //context.startActivity(Intent(context, ::class.java))
                Toast.makeText(context, "Join!", Toast.LENGTH_SHORT).show()
            },

            ) {
            Text("Join!", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.primary)
        }
    }

}