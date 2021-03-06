package com.ex.volunteerfinder.view.ui.composables

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.model.data.model.ApiEvent
import com.ex.volunteerfinder.view.EventDetailedViewAPI
import com.ex.volunteerfinder.view.EventDetailedViewAPIScreen
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.viewmodel.ApiEventViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LazyEventColumn(apiEventViewModel: ApiEventViewModel) {
    var events = apiEventViewModel.events
    var listLength = events.size

    LazyColumn {
        items(listLength) {

            index ->
            ApiEvent(events[index])

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ApiEvent(apiEvent: ApiEvent) {
    val context = LocalContext.current
    Card(modifier = Modifier.padding(4.dp),
        elevation = 0.dp,
        onClick = {context.startActivity(Intent(context, EventDetailedViewAPI::class.java)) }) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = apiEvent.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = apiEvent.address,
                    fontSize = 12.sp
                )
                Text(
                    text = apiEvent.time.toString(),
                    fontSize = 10.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}