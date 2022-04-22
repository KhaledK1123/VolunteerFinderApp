package com.ex.volunteerfinder.widgets

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun dateScheduler():String{
    val context = LocalContext.current
    val year:Int
    val month:Int
    val day:Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    var event by remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year:Int, month:Int, dayOfMonth: Int ->
            event = "${month+1}/$dayOfMonth/$year"
        },year,month,day
    )

    Button(onClick = {
        datePickerDialog.show()
    }) {
        Text(text = "Enter Event Date")
    }
    Spacer(modifier = Modifier.size(16.dp))

    Text(text = "Selected Date: $event",
        fontSize = 15.sp,
        textAlign = TextAlign.Center)
    return event
}

@Composable
fun timeScheduler():String{

    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    var time = remember {
        mutableStateOf("")
    }

    val timePickerDialog = TimePickerDialog(
        context,
        {_,hour: Int, minute:Int,->
            var hour = hour
            var meridiem = ""
            when{hour == 0 -> {hour+=12
                meridiem = "AM"
            }
                hour == 12-> meridiem ="PM"
                hour > 12 -> {hour -= 12
                    meridiem = "PM"
                }
                else -> meridiem = "AM"

            }
            if(minute ==0){
                time.value ="$hour:00 $meridiem"
            }else if(minute < 10){
                time.value ="$hour:0$minute $meridiem"
            }else{
                time.value ="$hour:$minute $meridiem"
            }

        },hour,minute,false
    )

    Column(
//        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Time: ${time.value}")
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = { timePickerDialog.show() }) {
            Text(text = "Select The Time")
        }
    }
    return time.value
}