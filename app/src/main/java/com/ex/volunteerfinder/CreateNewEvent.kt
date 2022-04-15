package com.ex.volunteerfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

class CreateNewEvent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreateNewEventScreen(){
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        TopAppBar(title = { Text(text = "Create New Event")})

        Column(modifier = Modifier,horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
            val eventName = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = eventName.value,
                onValueChange = {eventName.value = it},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {}
                )
            )
        }
    }
}