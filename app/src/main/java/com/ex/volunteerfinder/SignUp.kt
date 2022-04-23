package com.ex.volunteerfinder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.view.LoginText
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.LoginViewer
import com.ex.volunteerfinder.view.ui.CancelButton
import com.ex.volunteerfinder.view.ui.ForgotPassword
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            VolunteerFinderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        SignUpScreen(userViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(userViewModel: UserViewModel) {


    var primaryColor= Color.Gray
Scaffold() {


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = CircleShape
                ),

            painter = painterResource(id = R.drawable.logoonly),//password drawable
            contentDescription = "Circular Image"
        )

        Spacer(modifier = Modifier.height(5.dp))

        var username = remember { mutableStateOf("") }
        var email = remember { mutableStateOf("") }
        var name = remember { mutableStateOf("") }
        var city = remember { mutableStateOf("") }
        var state = remember { mutableStateOf("") }
        var zip = remember { mutableStateOf("00000") }
        var password = remember { mutableStateOf("") }
        var passwordConfirm = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }
        val confirmPasswordVisibility = remember { mutableStateOf(false) }


        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Username") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Username")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Email") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Name") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Name")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = city.value,
            onValueChange = { city.value = it },
            label = { Text(text = "City") },
            placeholder = { Text(text = "City") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "City")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = state.value,
            onValueChange = { state.value = it },
            label = { Text(text = "State") },
            placeholder = { Text(text = "State") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "State")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = zip.value,
            onValueChange = { zip.value = it },
            label = { Text(text = "Zip Code") },
            placeholder = { Text(text = "Zip Code") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Zip Code")

                }
            }
        )
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
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
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        imageVector = vectorResource(id = R.drawable.password),//password drawable
                        tint = if (passwordVisibility.value) primaryColor else Color.Gray
                    )
                }


            },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = passwordConfirm.value,
            onValueChange = { passwordConfirm.value = it },
            label = { Text(text = "Confirm Password") },
            placeholder = { Text(text = "Confirm Password") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock")

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                }) {
                    val primaryColor = Color.Gray
                    Icon(
                        imageVector = vectorResource(id = R.drawable.password), //password drawable
                        tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                    )
                }


            },
            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))
        val context = LocalContext.current
        Button(onClick =
        {

            if (username.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (email.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (name.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (city.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (state.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (zip.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (password.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (passwordConfirm.value.isEmpty()) {
                Toast.makeText(context, "Please fill all inputs ", Toast.LENGTH_SHORT).show()
            } else if (passwordConfirm.value != password.value ) {
                Toast.makeText(context, "Passwords must match ", Toast.LENGTH_SHORT).show()
            } else if (username.value == password.value) {
                Toast.makeText(context, "Username and password can not match", Toast.LENGTH_SHORT).show()
            }
//            else if (zip.value < 0) {
//                Toast.makeText(context, "Passwords must match ", Toast.LENGTH_SHORT).show()
//            }
            else {
                userViewModel.insertUser(
                    User(
                        userName = username.value,
                        email = email.value,
                        password = password.value,
                        name = name.value,
                        city = city.value,
                        state = state.value,
                        zipCode = zip.value.toInt()
                    )
                )
                context.startActivity(Intent(context, LoginView::class.java))
                Toast.makeText(context, "Signed Up Successfully", Toast.LENGTH_SHORT).show()
            }


        }
        ) {
            Text(text = "Submit")

        }
        CancelButton()

    }
}
}

fun Icon(imageVector: Any, tint: Color) {

}

fun vectorResource(id: Int) {

}


//if (!password.equals(passwordConfirm){
//    Toast.makeText(this, "Password Mismatches", Toast.LENGTH_SHORT).show()
//}
//else{
//    Toast.makeText(this,"Password Matches",Toast.LENGTH_SHORT).show()
//}
