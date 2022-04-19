package com.ex.volunteerfinder.view.ui.composables

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ex.volunteerfinder.R

@Composable
fun NewCircleButton(drawable: Int, intent: Intent? = null) {

    Button(onClick = {/*TODO pass intent parameter*/},
        shape = CircleShape
        ) {
        Icon(painter = painterResource(id = drawable), contentDescription ="")
    }
}

@Preview
@Composable
fun PreviewNewCircleButton() {
    val drawable = R.drawable.ic_home

    NewCircleButton(drawable = drawable)
}

/**
 * A composable function for displaying a generic text field. Currently takes one parameter,
 * which is the placeholder to be displayed. Still needs to be able to send text entry to
 * back end via callback. The question now is how to describe it as a parameter.
 */
@Composable
fun GenericTextField(placeholder: String = "Placeholder"){

    var text by remember { mutableStateOf("")}

    TextField(value = text,
        onValueChange = { text = it},
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape
        )
}

@Preview
@Composable
fun PreviewGenericTextField () {
    GenericTextField()
}