package com.ex.volunteerfinder.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ex.volunteerfinder.model.LoginView

import org.w3c.dom.Text

// MAY want to edit more, 4/14/22 AM, @bottom of code (time permitted); not 100% set, w/this

class ForgotPassword: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SimpleText("Create New Password")

                SubmitButton()

            }
        }
    }
}

class SubmitButton {

}

/* Attempted '@Preview', w/Composables: decided to forego (time constraints; questioning . . .
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
fun CancelButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },

            ) {
            Text("Cancel", color = Color(0xFF1333F3))
        }
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

@Composable
fun SubmitButton() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
    {

        var newPasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordInput by rememberSaveable { mutableStateOf("") }

        NewPassword(text = "Password!")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = newPasswordInput,
            onValueChange = { newPasswordInput = it })

        ConfirmPassword(text = "Confirm Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it })

        var status by rememberSaveable {
            mutableStateOf("")

        }

        val backgroundColor = Color(0xFF1333F3)
        Button(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(30.dp)
                .width(150.dp),
            onClick = {
                status =
                    newPasswordInput(newPasswordInput, confirmPasswordInput); context.startActivity(
                Intent(context, LoginView::class.java)
            )
            }
        )
    }

    }
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




