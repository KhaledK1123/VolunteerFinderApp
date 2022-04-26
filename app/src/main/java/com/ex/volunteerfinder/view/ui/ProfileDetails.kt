package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.StoreUserInfo
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
        //val userList = userViewModel.fetchAllUsers().observeAsState(arrayListOf())
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
                        RoundImage(
                            image = painterResource(id = R.drawable.img2),
                            modifier = Modifier
                                .size(175.dp)
                                .weight(3f)
                                .clickable(onClick = {

                                })
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column(

                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = 75.dp),
                        Arrangement.Top,
                        Alignment.CenterHorizontally
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
                }
            }
        }
}