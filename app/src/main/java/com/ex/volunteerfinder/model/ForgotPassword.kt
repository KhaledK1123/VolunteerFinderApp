package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.vectorResource
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel

class ForgotPassword: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setContent {
            VolunteerFinderAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        SubmitButton(userViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun CancelButton() {

    Column(
        modifier = Modifier, Arrangement.Bottom, Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, LoginView::class.java))
            },

            ) {
            Text("Cancel", color = Color(0xFF1333F3))
        }
    }
}



    @Composable
    fun SubmitButton(userViewModel: UserViewModel) {


        var primaryColor= Color.Gray
        val userList = userViewModel.fetchAllUsers().observeAsState(arrayListOf())
        val context = LocalContext.current
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

                painter = painterResource(id = R.drawable.volunteer),//password drawable
                contentDescription = "Circular Image"
            )

            Spacer(modifier = Modifier.height(20.dp))

            var username = remember { mutableStateOf("") }
            var password = remember { mutableStateOf("") }
            var email = remember { mutableStateOf("")}
            var passwordConfirm = remember { mutableStateOf("") }

            var passwordVisibility by remember { mutableStateOf(false) }
            var confirmPasswordVisibility by remember { mutableStateOf(false) }
            
            val icon = if(passwordVisibility)
                painterResource(id = R.drawable.visibility_fill0_wght400_grad0_opsz48)
            else
                painterResource(id = R.drawable.visibility_off_fill0_wght400_grad0_opsz48)

            val icon1 = if (confirmPasswordVisibility)
                painterResource(id = R.drawable.visibility_fill0_wght400_grad0_opsz48)
            else
                painterResource(id = R.drawable.visibility_off_fill0_wght400_grad0_opsz48)

            OutlinedTextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "Username") },
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "Person")

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
                    //Checking for it to work
                    IconButton(onClick = { /*TODO*/}) {
                        Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock")


                    }
                },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility=!passwordVisibility

                    }) {
                        Icon(painter = icon, contentDescription = "visibility icon")

                    }


                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
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
                        confirmPasswordVisibility=!confirmPasswordVisibility

                    }) {
                        Icon(painter = icon1, contentDescription = "visibility icon")

                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None
                else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = email.value,
                onValueChange = {email.value = it},
                label = {
                    Text(text = "Verify Your Email")
                },
                placeholder = { Text(text = "Verify Your Email") },
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
                }
            )

            Spacer(modifier = Modifier.height(25.dp))
            Button(onClick =
            {

                val change = userList.value
                change.forEach {user ->
                    if (username.value.isEmpty()){
                        Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
                    }
                    else if(password.value.isEmpty()){
                        Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
                    }
                    else if(passwordConfirm.value.isEmpty()){
                        Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
                    }
                    else if(email.value.isEmpty()){
                        Toast.makeText(context,"Please fill all inputs ",Toast.LENGTH_SHORT).show()
                    }
                    else if (!email.value.equals(user.email)){
                        Toast.makeText(context,"Wrong Entry",Toast.LENGTH_SHORT).show()
                    }
                    else if (!username.value.equals(user.userName)){
                        Toast.makeText(context,"Username is not recognized",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        userViewModel.insertUser(User(
                            userName = user.userName,
                            password = password.value,
                            email = user.email,
                            name = user.name,
                            city = user.city,
                            state = user.state,
                            zipCode = user.zipCode
                        ))
                        userViewModel.deleteUser(user.id)
                        context.startActivity(Intent(context, LoginView::class.java))
                        Toast.makeText(context,"Password Updated!",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            ) {
                Text(text = "Submit")

            }

            CancelButton()
        }

    }

/* Attempted '@Preview', w/Composables, here: decided to forego (time constraints; questioning . . .
. . . their necessity & usability, as a result) */
@Composable
fun SimpleText(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.SansSerif,
        fontSize = 30.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Username(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Blue
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 75.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun NewPassword(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Blue
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 50.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )

    CancelButton()
}
@Composable
fun ConfirmPassword(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Blue
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 25.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

fun newPasswordInput(new_password: String, confirm_password: String): String {

    var status: String = ""

    if (new_password.equals("Password!") && confirm_password.equals("Password!")) {

        status = "Confirmed"

    } else {

        status = "Deny"
    }

    return status
}

fun Button(shape: RoundedCornerShape, colors: ButtonColors, modifier: Modifier, onClick: () -> Unit) {

}
