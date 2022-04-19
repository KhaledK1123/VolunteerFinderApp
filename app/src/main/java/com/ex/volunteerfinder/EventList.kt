package com.ex.volunteerfinder


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel
import com.ex.volunteerfinder.widgets.EventList
import com.ex.volunteerfinder.widgets.dateScheduler

class EventList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EventListScreen()
                }
            }
        }
    }
}



@Composable
fun EventListScreen(){

    Column {
        TopAppBar(title = { Text(text = "Event List")})

        Column(modifier = Modifier,horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {

            dateScheduler()

            Spacer(modifier = Modifier.size(16.dp))

            Column(
                modifier = Modifier.padding(bottom = 50.dp)
            ){
                EventList()
            }
        }
    }
}