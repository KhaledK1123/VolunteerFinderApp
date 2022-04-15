package com.ex.volunteerfinder.widgets

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
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