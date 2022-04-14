package com.ex.volunteerfinder

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable

fun SignUp() {

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

            painter = painterResource(id = R.drawable.volunteer),
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
                        imageVector = vectorResource(id = R.drawable.password),
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
                        imageVector = vectorResource(id = R.drawable.password),
                        tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                    )
                }


            },
            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {}
//        {
//            if (username.value.isEmpty()){
//                Toast.makeText(context,"Please complete ",Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(context,"Signed Up Successfully",Toast.LENGTH_SHORT).show()
//            }
//        }
        ) {
            Text(text = "Submit")

        }


    }
}

fun Icon(imageVector: Any, tint: Color) {

}

fun vectorResource(id: Int) {

}

