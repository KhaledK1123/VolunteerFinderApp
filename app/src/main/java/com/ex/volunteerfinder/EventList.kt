package com.ex.volunteerfinder


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.MainScreen
import com.ex.volunteerfinder.view.NavigationItem
import com.ex.volunteerfinder.view.ui.VolunteerProfile
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel
import com.ex.volunteerfinder.widgets.EventList
import com.ex.volunteerfinder.widgets.dateScheduler

class EventList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val eventViewModel = ViewModelProvider(this)[EventViewModel::class.java]
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventListScreen(eventViewModel)
                }
            }
            }
        }
    }




@Composable
fun EventListScreen(eventViewModel: EventViewModel){


    Column {

        TopAppBar(title = { Text(text = "Event List") },
            navigationIcon =
                {
                    val context = LocalContext.current
                    IconButton(onClick = { context.startActivity(Intent(context, VolunteerProfile::class.java)) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }

        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

//            dateScheduler()

//            Spacer(modifier = Modifier.size(16.dp))

            Column()
            {
                EventList(eventViewModel)
            }
        }
    }
}


@Composable
fun PreEventListScreen()
{
    VolunteerFinderAppTheme {


        val context = LocalContext.current
        Column() {

            Button(onClick = { context.startActivity(Intent(context, EventList::class.java)) }) {
                Text(text = "Go to My Events!")
            }
        }
    }
}