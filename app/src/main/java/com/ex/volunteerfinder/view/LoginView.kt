package com.ex.volunteerfinder.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.SignUp
import com.ex.volunteerfinder.model.data.StoreUserInfo
import com.ex.volunteerfinder.view.ui.ForgotPassword
import com.ex.volunteerfinder.view.ui.VolunteerProfile
import com.ex.volunteerfinder.view.ui.theme.Shapes
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel
import kotlinx.coroutines.launch


class LoginView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
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
                        LoginViewer(userViewModel)
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
            context.startActivity(Intent(context, ForgotPassword::class.java))

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
                        context.startActivity(Intent(context, SignUp::class.java))
                    },

                    ) {
                    Text("Sign Up", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.primaryVariant)
                }
            }
        }
    }
}

@Composable
fun LoginViewer(userViewModel: UserViewModel) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    // we instantiate the saveEmail class
    val dataStore = StoreUserInfo(context)
    val userList = userViewModel.fetchAllUsers().observeAsState(arrayListOf())
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
        var wordVisibility by remember { mutableStateOf(false)}

        val display = if (wordVisibility)
            painterResource(id = R.drawable.visibility_fill0_wght400_grad0_opsz48)
        else
            painterResource(id = R.drawable.visibility_off_fill0_wght400_grad0_opsz48)


        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Username") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Username")

                }
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Password") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock")

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    wordVisibility=!wordVisibility

                }) {
                    Icon(painter = display, contentDescription = "visibility icon")

                }


            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (wordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        //Calling ForgotPasswordButton function that displays 'Forgot Password'
        ForgotPasswordButton()

        isError = username.isEmpty() or password.isEmpty()

        val context = LocalContext.current

        Button(shape = Shapes.medium,
            //colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .padding(15.dp)
                .width(280.dp),

            onClick = {
                //This allows the login button to traverse to Home page
                val log = userList.value
                log.forEach { user ->
                    if (!isError && user.userName == username && user.password == password) {
//                        val prefs: SharedPreferences = this.getSharedPreferences(
//                            "com.example.app", Context.MODE_PRIVATE
//                        )
//                        prefs.edit().putString("name", user.userName).apply()
                        scope.launch {
                            user.userName?.let { dataStore.saveUsername(it) }
                            user.name?.let { dataStore.saveName(it) }
                            user.city?.let { dataStore.saveCity(it) }
                            user.email?.let { dataStore.saveEmail(it) }
                            user.zipCode?.let { dataStore.saveZipCode(it) }
                            user.state?.let { dataStore.saveState(it) }
                        }

                        context.startActivity(Intent(context, VolunteerProfile::class.java)
                            .putExtra("username", user.userName)
                            .putExtra("email", user.email)
                            .putExtra("name", user.name)
                            .putExtra("city", user.city)
                            .putExtra("zip", user.zipCode)
                            .putExtra("state", user.state)
                            .putExtra("username1", username)
                            .putExtra("password1", password))

                        Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "Login Unsuccessful!", Toast.LENGTH_SHORT).show()
                    }
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