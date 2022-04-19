package com.ex.volunteerfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel
import com.ex.volunteerfinder.widgets.dateScheduler
import com.ex.volunteerfinder.widgets.timeScheduler

class CreateNewEvent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val eventViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateNewEventScreen(eventViewModel)
                }
            }
        }
    }
}


@Composable
fun stateDropDownMenu(list: List<String>,defaultText:String):String{
    var expanded by remember { mutableStateOf(false) }

    var state by remember { mutableStateOf("") }

    var textFilledSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier
        .padding(20.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                textFilledSize = coordinates.size.toSize()
            }
            .border(border = BorderStroke(2.dp, Color.Black))
            .padding(3.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(value = state,
                    onValueChange = {state = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            textFilledSize = coordinates.size.toSize()
                        },
                    label = { Text(text = defaultText)},
                    trailingIcon = {
                        Icon(imageVector = icon,
                            contentDescription = "",modifier = Modifier
                                .clickable { expanded = !expanded }
                                .background(color = MaterialTheme.colors.primary))
                    }
                )
            }
        }

        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textFilledSize.width.toDp()})
        ) {
            list.forEach { label->
                DropdownMenuItem(onClick = {
                    state = label
                    expanded = false
                }) {
                    Text(text = label)
                }

            }
        }
    }
    return state
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreateNewEventScreen(eventViewModel: EventViewModel){
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val stateList = listOf("Alabama",
            "Alaska", "Arizona", "Arkansas",
            "California", "Colorado", "Connecticut",
            "Delaware", "Florida", "Georgia",
            "Hawaii", "Idaho",
            "Illinois", "Indiana","Iowa",
            "Kansas", "Kentucky", "Louisiana",
            "Maine", "Maryland","Massachusetts","Michigan","Minnesota",
            "Mississippi","Missouri", "Montana",
            "Nebraska", "Nevada","New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Carolina", "North Dakota",
            "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
            "Rhode Island", "South Carolina", "South Dakota",
            "Tennessee", "Texas", "Utah",
            "Vermont", "Virginia",
            "Washington", "West Virginia", "Wisconsin", "Wyoming"
    )

    Column {
        TopAppBar(title = { Text(text = "Create New Event")})

        Column(modifier = Modifier,horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
            //Event Name
            val eventName = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = eventName.value,
                onValueChange = {eventName.value = it},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
            //Event Sponsor
            val eventSponsor = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = eventSponsor.value,
                onValueChange = {eventSponsor.value = it},
                placeholder = { Text(text = "Event Sponsor")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
            //Head person of the event
            val leader = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = leader.value,
                onValueChange = {leader.value = it},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
            val street = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = street.value,
                onValueChange = {street.value = it},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
            val city = rememberSaveable {
                mutableStateOf("")
            }
            TextField(value = city.value,
                onValueChange = {city.value = it},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )

            stateDropDownMenu(list = stateList, defaultText = "Select or Enter State")

            var stateSelected = stateDropDownMenu(list = stateList, defaultText = "Select or Enter State")

            Spacer(modifier = Modifier.size(16.dp))
            
            dateScheduler()
            
            Spacer(modifier = Modifier.size(16.dp))
            
            timeScheduler()
            
            Spacer(modifier = Modifier.size(20.dp))

            Button(onClick = { eventViewModel.insertEvent(
                MyEvent(
                    name = eventName.value,
                    sponsor = eventSponsor.value,
                    leadership = leader.value,
                    address = street.value,
                    city = city.value,
                    state = stateSelected))
            }) {
                Text(text = "Finish!")
            }
        }
    }
}