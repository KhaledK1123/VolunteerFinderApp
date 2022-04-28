package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ex.volunteerfinder.EventList
import com.ex.volunteerfinder.view.ui.composables.LazyEventColumn
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.ApiEventViewModel

class ApiEvents : ComponentActivity() {

    val apiEventViewModel by viewModels<ApiEventViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            apiEventsFunction(apiEventViewModel)

        }
    }
}

@Composable
fun apiEventsFunction(apiEventViewModel:ApiEventViewModel)
{
    VolunteerFinderAppTheme() {

        Scaffold(
            topBar = {

                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    title = { Text("Previous Events") },
                    navigationIcon =
                    {
                        val context = LocalContext.current
                        IconButton(onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    VolunteerProfile::class.java
                                )
                            )
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                LazyEventColumn(apiEventViewModel = apiEventViewModel)
            }
        }
    }
}