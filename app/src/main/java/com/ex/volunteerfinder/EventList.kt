package com.ex.volunteerfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ex.volunteerfinder.ui.theme.VolunteerFinderAppTheme

class EventList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting1("New Project")
                }
            }
        }
    }
}

@Composable
fun Greeting1(name: String) {
    Text(text = "Hello $name!")
    Text(text ="I am here. I am $name")
    Text(text = "Hello $name!")
    Text(text = "Hello again")
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    VolunteerFinderAppTheme {
//        Greeting1("Android")
//    }
//}