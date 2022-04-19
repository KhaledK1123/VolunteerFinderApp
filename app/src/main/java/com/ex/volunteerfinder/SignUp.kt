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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ex.volunteerfinder.view.LoginText
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.LoginViewer
import com.ex.volunteerfinder.view.ui.CancelButton
import com.ex.volunteerfinder.view.ui.ForgotPassword
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

class SignUp : ComponentActivity() {
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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        SignUpScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {


    var primaryColor= Color.Gray

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

        Spacer(modifier = Modifier.height(20.dp))

        var username = remember { mutableStateOf("") }
        var email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var passwordConfirm = remember { mutableStateOf("") }

        val passwordVisibility = remember { mutableStateOf(false) }
        val confirmPasswordVisibility = remember { mutableStateOf(false) }


        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Name") },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Person")

                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

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

        Spacer(modifier = Modifier.height(20.dp))

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
                    passwordVisibility.value=!passwordVisibility.value
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

        Spacer(modifier = Modifier.height(20.dp))

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
                    confirmPasswordVisibility.value=!confirmPasswordVisibility.value
                }) {
                    val primaryColor= Color.Gray
                    Icon(
                        imageVector = vectorResource(id = R.drawable.password), //password drawable
                        tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                    )
                }


            },
            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(25.dp))
        val context = LocalContext.current
        Button(onClick =
        {

            if (username.value.isEmpty()){
                Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
            }
            else if(email.value.isEmpty()){
            Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
            }
            else if(password.value.isEmpty()){
                Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
            }
            else if(passwordConfirm.value.isEmpty()){
                Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
            }
            else{
                context.startActivity(Intent(context, MainActivity::class.java))
                Toast.makeText(context,"Signed Up Successfully",Toast.LENGTH_SHORT).show()
            }


        }
        ) {
            Text(text = "Submit")

        }
        CancelButton()

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
