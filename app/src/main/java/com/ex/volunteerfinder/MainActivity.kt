package com.ex.volunteerfinder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.view.LoginText
import com.ex.volunteerfinder.view.LoginViewer
import com.ex.volunteerfinder.view.ui.VolunteerProfile
import com.ex.volunteerfinder.view.ui.theme.Shapes
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //SignUp(this)
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoginText(displayText = "Volunteer Finder")
                        Image(painterResource(R.drawable.icon),"content")
                        LoginViewer()
//                        EventMap()
                    }

                }
            }
        }
    }
}

//@Composable
//fun MainActivityScreen() {
//    Scaffold(
//        topBar = {
//
//            TopAppBar(
//                backgroundColor = MaterialTheme.colors.primary,
//                title = {Text("Donations")})
//        }
//    ) {
//        Column(
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Column(
//            ) {
////                val context = LocalContext.current
////                Button(onClick = { context.startActivity(Intent(context, VolunteerProfile::class.java))},
////                    modifier = Modifier
////                        .padding(top = 2.dp, start = 15.dp, end = 15.dp)
////                        .fillMaxWidth()
////                        .clip(Shapes.medium)) {
////                    Text(text = "Create Post")
////                }
//            }
//
//        }
//    }
//}

/*
@Composable
fun MainActivityScreen() {
    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Donations")})
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
            ) {
//                val context = LocalContext.current
//                Button(onClick = { context.startActivity(Intent(context, VolunteerProfile::class.java))},
//                    modifier = Modifier
//                        .padding(top = 2.dp, start = 15.dp, end = 15.dp)
//                        .fillMaxWidth()
//                        .clip(Shapes.medium)) {
//                    Text(text = "Create Post")
//                }
            }

        }
    }
}
*/
