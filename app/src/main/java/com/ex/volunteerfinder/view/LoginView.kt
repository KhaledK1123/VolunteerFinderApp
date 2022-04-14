package com.ex.volunteerfinder.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.view.ui.theme.Shapes
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

class LoginView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoginText(displayText = "Volunteer Finder")
                        Image(painterResource(R.drawable.icon),"content")
                        LoginViewer()
                    }




                }
            }
        }
    }
}

@Composable
fun LoginText(displayText: String) {

    Text(
        color = MaterialTheme.colors.primaryVariant,
        text = displayText,
        style= MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = 175.dp),
        fontSize = 40.sp,
    )
}

@Composable
fun ForgotPasswordButton() {

    val context = LocalContext.current
    TextButton(
        onClick = {
//            context.startActivity(Intent(context, ForgotPasswordView::class.java))

        },
        modifier = Modifier.absolutePadding(left = 235.dp)
    ) {
        Text("Forgot Password", style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.primaryVariant)
    }
}

@Composable
fun CreateAccountButton() {


    Row() {
        Column(

            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 15.dp),
            Arrangement.Bottom
        ) {

            Text(text = "Need an account?", style = MaterialTheme.typography.h6)
        }

        Row() {

            Column(

                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 6.dp),
                Arrangement.Bottom
            ) {

                val context = LocalContext.current
                TextButton(
                    onClick = {
//                        context.startActivity(Intent(context, CreateAccountView::class.java))
                    },

                    ) {
                    Text("Sign Up", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.primaryVariant)
                }
            }
        }
    }
}

@Composable
fun LoginViewer() {
    LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),

        )
    {

        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }
        TextField(
            value = username,
            isError = false,
            onValueChange = { username = it },
            label = { Text(if(isError)"User Name*" else("User Name"),
                style = MaterialTheme.typography.subtitle1) },
            modifier = Modifier
                .padding(top = 35.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(if(isError)"Password*" else("Password"),
                style = MaterialTheme.typography.subtitle1) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .padding(bottom = 10.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .clip(Shapes.medium)
        )

        //Calling ForgotPasswordButton function that displays 'Forgot Password'
        ForgotPasswordButton()

        isError = username.isEmpty() or password.isEmpty()

        val context = LocalContext.current

        Button(shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),

            onClick = {
                //This allows the login button to traverse to Home page
                if (!isError) {
                    //viewModel.login(username, password)
                    //context.startActivity(Intent(context, EventList::class.java))
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Login Unsuccessful!", Toast.LENGTH_SHORT).show()
                }

            }) {

            Text(
                text = "Login",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(1.dp)
            )
        }
    }

    //Calling CreateAccountButton function that displays 'Sign Up' at the bottom
    CreateAccountButton()
}