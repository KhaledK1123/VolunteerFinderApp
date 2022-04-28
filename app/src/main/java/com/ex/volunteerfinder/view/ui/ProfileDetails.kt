package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.StoreUserInfo
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel

class ProfileDetails : ComponentActivity() {
    // @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        setContent {
            Scaffold {

                ProfileScreen(userViewModel)

            }
        }
    }
}

@Composable
fun ProfileScreen(userViewModel: UserViewModel) {
    VolunteerFinderAppTheme() {
        val context = LocalContext.current
        val dataStore = StoreUserInfo(context)
        val userList = userViewModel.fetchAllUsers().observeAsState(arrayListOf())
        val userEmail = dataStore.getEmail.collectAsState(initial = "")
        val userUserName = dataStore.getUsername.collectAsState(initial = "")
        val userName = dataStore.getName.collectAsState(initial = "")
        val userCity = dataStore.getCity.collectAsState(initial = "")
        val userState = dataStore.getState.collectAsState(initial = "")
        val userZipCode = dataStore.getZipCode.collectAsState(initial = "")

            Scaffold(
                topBar = {

                    TopAppBar(
                        backgroundColor = MaterialTheme.colors.primary,
                        title = { Text("Profile Details") },
                        navigationIcon =
                        {
                            //val context = LocalContext.current
                            IconButton(onClick = { context.startActivity(Intent(context, VolunteerProfile::class.java)) }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        })
                }
            )
            {
                Column(Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {

                        val imageData = remember { mutableStateOf(null) }
                        val launcher =
                            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                                imageData.value = it as Nothing?
                            }
                        RoundImage(
                            image = painterResource(id = R.drawable.img2),
                            modifier = Modifier
                                .size(175.dp)
                                .weight(3f)
                                .clickable(onClick = {
                                    launcher.launch(
                                        "image/*"
                                    )
                                })
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column(

                        modifier = Modifier,
                        Arrangement.Top,
                        Alignment.Start
                    ) {



                        Text(text = "Username: " + userUserName.value!!)
                        Text(text = "Email: " + userEmail.value!!)
                        Text(text = "Name: " + userName.value!!)
                        Text(text = "Address: " + userCity.value!! + ", " + userState.value!! + ", " + userZipCode.value)
                        //Text(text = "Username: " + userState.value!!)
                        //Text(text = "Zip Code: " + userZipCode.value!!)
//                        val log = userList.value
//                        log.forEach { user ->
//                            if (user.name != "hi") {
//                                user.name?.let { it1 -> Text(text = "hi $it1") }
//                            }
//                        }
                    }
                    var username = remember { mutableStateOf("") }
                    var email = remember { mutableStateOf("") }
                    var name = remember { mutableStateOf("") }
                    var city = remember { mutableStateOf("") }
                    var state = remember { mutableStateOf("") }
                    var zip = remember { mutableStateOf("00000") }
                    var password = remember { mutableStateOf("") }
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

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                            ){
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
//                        Spacer(modifier = Modifier.height(5.dp))
//                        OutlinedTextField(
//                            value = city.value,
//                            onValueChange = { city.value = it },
//                            label = { Text(text = "City") },
//                            placeholder = { Text(text = "City") },
//                            singleLine = true,
//                            leadingIcon = {
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(imageVector = Icons.Filled.Home, contentDescription = "City")
//
//                                }
//                            }
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        OutlinedTextField(
//                            value = state.value,
//                            onValueChange = { state.value = it },
//                            label = { Text(text = "State") },
//                            placeholder = { Text(text = "State") },
//                            singleLine = true,
//                            leadingIcon = {
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(imageVector = Icons.Filled.Home, contentDescription = "State")
//
//                                }
//                            }
//                        )
//                        Spacer(modifier = Modifier.height(5.dp))
//                        OutlinedTextField(
//                            value = zip.value,
//                            onValueChange = { zip.value = it },
//                            label = { Text(text = "Zip Code") },
//                            placeholder = { Text(text = "Zip Code") },
//                            singleLine = true,
//                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                            leadingIcon = {
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Zip Code")
//
//                                }
//                            }
//                        )
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
                        //val context = LocalContext.current
                        Button(onClick = {
                            val change =userList.value
                            change.forEach {user->
                                if (username.value.isEmpty()){
                                    Toast.makeText(context,"Please fill all inputs ", Toast.LENGTH_SHORT).show()
                                }
                                else if(password.value.isEmpty()){
                                    Toast.makeText(context,"Please fill all inputs ", Toast.LENGTH_SHORT).show()
                                }
                                else if(passwordConfirm.value.isEmpty()){
                                    Toast.makeText(context,"Please fill all inputs ", Toast.LENGTH_SHORT).show()
                                }
                                else if(email.value.isEmpty()){
                                    Toast.makeText(context,"Please fill all inputs ", Toast.LENGTH_SHORT).show()
                                }
                                else if (!email.value.equals(user.email)){
                                    Toast.makeText(context,"Wrong Entry", Toast.LENGTH_SHORT).show()
                                }
                                else if (!username.value.equals(user.userName)){
                                    Toast.makeText(context,"Username is not recognized", Toast.LENGTH_SHORT).show()
                                }
                                else{
                                    userViewModel.insertUser(
                                        User(
                                        userName = user.userName,
                                        password = password.value,
                                        email = user.email,
                                        name = user.name,
                                        city = user.city,
                                        state = user.state,
                                        zipCode = user.zipCode
                                    )
                                    )
                                    userViewModel.deleteUser(user.id)
                                    context.startActivity(Intent(context, VolunteerProfile::class.java))
                                    Toast.makeText(context,"Password Updated!",Toast.LENGTH_SHORT).show()
                                }
                            }


                            context.startActivity(Intent(context, VolunteerProfile::class.java)) }
                        ) {
                                Text(text = "Change Info")
                        }
                    }
                }
            }
        }
}