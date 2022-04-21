package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.MainActivity
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.SignUp
import com.ex.volunteerfinder.view.MainScreen

/* Richard's idea: 'Composables' in THIS file, going forward; when calling 'ProfileImage()', here,
have "Boolean=true" */
class VolunteerProfile : ComponentActivity() {
    // @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
            /* Starting below, & for following, 5 lines: replaced ('MainScreen()')
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) */
            }
}

@Composable
fun ProfileDescription(
    displayName: String,
    username: String,
    email: String,
    address: String,
    volunteeredEventsCount: Int,
    volunteeredNumberOfTimesCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Name: $displayName",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Username: $username",
            style = MaterialTheme.typography.body1,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Email: $email",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = "Address: $address",
            style = MaterialTheme.typography.body1,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = buildAnnotatedString {
                append("Volunteered $volunteeredEventsCount times!")
            },
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

    }
}

@Composable
fun ProfileImage (thumbnail: Boolean = true) {

    Image(painter = painterResource(R.drawable.blankpfp),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .absolutePadding(left = 8.dp, top=64.dp)
            .size(
                if (thumbnail) {
                    40.dp
                } else {
                    128.dp
                }
            )
            .clip(CircleShape)
    )
}

@Preview
@Composable
fun PreviewProfileImage() {
    com.ex.volunteerfinder.view.ui.composables.ProfileImage(thumbnail = true)

}

//-------------------------------------------------------------------------------------------------
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}

@Preview
@Composable
// @OptIn(ExperimentalFoundationApi::class)
fun ProfileScreen() {
    Scaffold(
        topBar = {

            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Profile")})
        }
    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .wrapContentSize(Alignment.Center)
//        ) {
//            TableRow(text = "APP")
//        }
    }

    ProfileImage()

    // Copied & adapted, from previous work
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDescription(
            displayName = "",
            username = "",
            email = "",
            address = "",
            volunteeredNumberOfTimesCount= 3
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 75.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Bottom,
            Alignment.Start

        ) {
            val context = LocalContext.current
            TextButton(
                onClick = {
                    context.startActivity(Intent(context, SignUp::class.java))
                })
        }
    }
}

fun TextButton(onClick: () -> Unit) {

}

@Preview
@Composable
fun SubmitButton2() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {
        var volunteeredNumberOfTimes by rememberSaveable { mutableStateOf("") }

        TextField(
            value = volunteeredNumberOfTimes,
            onValueChange = { volunteeredNumberOfTimes = it },
            label = { Text("Number of Volunteered Events") },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
        )

        var status by rememberSaveable {
            mutableStateOf("")

        }

        val backgroundColor = Color.Black
        Button2(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            onClick = {
                status =
                    VolunteeredNumberOfTimes(volunteeredNumberOfTimes);
                context.startActivity(Intent(context, MainActivity::class.java)
                )
            }
        )
    }
}

fun Row(verticalAlignment: Alignment.Vertical, modifier: Modifier) {

}

fun Column(modifier: Modifier, verticalArrangement: Arrangement.Vertical,
           horizontalAlignment: Alignment.Horizontal) {

}

fun ProfileDescription(displayName: String, username: String, email: String, address: String, volunteeredNumberOfTimesCount: Int) {

}

fun VolunteeredNumberOfTimes(volunteeredNumberOfTimes: String): String = Unit.toString()

fun Button2(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier,
            onClick: () -> Unit) {

}

/* Second line below, through the end: POSSIBLY re-use/adapt (Extra bar, RE: # of volunteered
events); otherwise, reference only
@Composable
fun TableRow(text: String) {
    Text(
        text = "One",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .absolutePadding(left = 8.dp)
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Two",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Three",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    );
    Text(
        text = "Four",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 72.dp)
    )
} */



