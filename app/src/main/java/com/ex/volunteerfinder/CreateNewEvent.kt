package com.ex.volunteerfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.model.data.MyEvent
import com.ex.volunteerfinder.view.ui.VolunteerProfile
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.EventViewModel
import com.ex.volunteerfinder.widgets.dateScheduler
import com.ex.volunteerfinder.widgets.timeScheduler
import java.lang.NumberFormatException

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
        .padding(10.dp)
    ) {
        Box(modifier = Modifier

            .onGloballyPositioned { coordinates ->
                textFilledSize = coordinates.size.toSize()
            }

        ) {
            Row(modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = state,
                    onValueChange = {state = it},
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp)
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
//This checks to make sure that the Zip Code is numerical.
fun checkNumber(s:String):Boolean{
    return try {
        s.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }
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
        TopAppBar(title = { Text(text = "Create New Event")},
        navigationIcon = {
            val context = LocalContext.current
            IconButton(onClick = {
                context.startActivity(
                    Intent(
                        context,
                        EventList::class.java
                    )
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        })

        Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
            //Event Name
            val eventName = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = eventName.value,
                onValueChange = {eventName.value = it},
                label = {Text(text = "Event Name")},
                placeholder = { Text(text = "Event Name")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
//            Spacer(modifier = Modifier.height(5.dp))
            //Event Sponsor
            val eventSponsor = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = eventSponsor.value,
                onValueChange = {eventSponsor.value = it},
                label ={Text(text = "Event Sponsor")},
                placeholder = { Text(text = "Event Sponsor")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
//            Spacer(modifier = Modifier.height(5.dp))
            //Head person of the event
            val leader = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = leader.value,
                onValueChange = {leader.value = it},
                label = {Text(text = "Leader")},
                placeholder = { Text(text = "Leader")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
//            Spacer(modifier = Modifier.height(5.dp))
            val street = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = street.value,
                onValueChange = {street.value = it},
                label = {Text(text = "Street")},
                placeholder = { Text(text = "Street")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )
//            Spacer(modifier = Modifier.height(5.dp))
            val city = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = city.value,
                onValueChange = {city.value = it},
                label ={Text(text = "City")},
                placeholder = { Text(text = "City")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )

            val zip = rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(modifier = Modifier.width(300.dp)
                .height(60.dp),
                value = zip.value,
                onValueChange = {zip.value = it},
                label ={Text(text = "Zip Code")},
                placeholder = { Text(text = "Zip Code")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(
                    onDone = {keyboardController?.hide()}
                )
            )


            var stateSelected = stateDropDownMenu(list = stateList, defaultText = "Select or Enter State")



            var date = dateScheduler()

            
            var time = timeScheduler()


            Button(onClick = {
                if (eventName.value.equals("")
                    || eventSponsor.value.equals("")
                    || leader.value.equals("")
                    || street.value.equals("")
                    || city.value.equals("")
                    || stateSelected.equals("")
                    || time.equals("")
                    || date.equals("")
                    || zip.value.equals("")

                ){
                    //This alerts that the Creation of the Event is not completed
                    Toast.makeText(context,"Event information is incomplete",Toast.LENGTH_LONG).show()
                }else if (!checkNumber(zip.value)
                    || zip.value.toInt() >= 100000
                    || zip.value.toInt() <0) {
                    Toast.makeText(context,"Invalid Zip Code",Toast.LENGTH_LONG).show()
                } else{
                    eventViewModel.insertEvent(
                        MyEvent(
                            name = eventName.value,
                            sponsor = eventSponsor.value,
                            leadership = leader.value,
                            address = street.value,
                            city = city.value,
                            state = stateSelected,
                            time = time,
                            date = date,
                            zipCode = zip.value.toInt()
                        ))
                    context.startActivity(Intent(context, EventList::class.java))
                }


            }) {
                Text(text = "Finish!")
            }
        }
    }
}