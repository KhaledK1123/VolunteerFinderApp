package com.ex.volunteerfinder.model

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.ViewModelProvider
import com.ex.volunteerfinder.model.data.User
import com.ex.volunteerfinder.view.LoginView
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.UserViewModel
import java.util.*

class ConfirmCode : ComponentActivity() {
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
                    ConfirmCodeScreen(userViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ConfirmCodeScreen(userViewModel: UserViewModel) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val userList = userViewModel.fetchAllUsers().observeAsState(arrayListOf())

    Column {
        TopAppBar(title = { Text(text = "Confirm Email Screen") })
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            //The intent is going to happen here instead of being within a button
            val confirm = userList.value
            val code = UUID.randomUUID().toString()
            val confirmationCode = rememberSaveable {
                mutableStateOf("")
            }
            var codeIsCorrect = false
            confirm.forEach { user->
//                val intent = Intent(Intent.ACTION_SENDTO).apply {
//                    data = Uri.parse("mailto:")
//                    putExtra(Intent.EXTRA_EMAIL,user.email)
//                    putExtra(Intent.EXTRA_SUBJECT,"Confirmation Code")
//                    putExtra(Intent.EXTRA_TEXT,code)
//                }

                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL,user.email)
                    putExtra(Intent.EXTRA_SUBJECT,"Confirmation Code")
                    putExtra(Intent.EXTRA_TEXT,code)
                }
                try{
                    context.startActivity(intent)
                }catch (e: ActivityNotFoundException){
                    Toast.makeText(context,"Required App isw not installed",Toast.LENGTH_SHORT).show()
                }
                Button(onClick = {
                    if (confirmationCode.value.equals(code)){
                        userViewModel.insertUser(
                            User(
                            userName = user.userName,
                            password = user.password, //needs to be changed
                            email = user.email,
                            name = user.name,
                            city = user.city,
                            state = user.state,
                            zipCode = user.zipCode
                        )
                        )
                        userViewModel.deleteUser(user.id)
                        context.startActivity(Intent(context, LoginView::class.java))
                        Toast.makeText(context,"Password Updated!",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context,"Invalid Code",Toast.LENGTH_SHORT).show()
                    }



                }) {

                }

            }





            OutlinedTextField(value = confirmationCode.value,
                onValueChange = {confirmationCode.value = it},
                label = {
                    Text(text = "Enter Code from your email")
                },
                singleLine = true,
//                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//                keyboardActions = KeyboardActions(
//                    onDone = {keyboardController?.hide()})
            )

        }
    }
}

