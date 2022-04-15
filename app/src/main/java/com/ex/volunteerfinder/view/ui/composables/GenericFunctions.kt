package com.ex.volunteerfinder.view.ui.composables

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ex.volunteerfinder.R

@Composable
fun NewCircleButton(drawable: Int, /*TODO Add param for destination*/) {

    Button(onClick = {},
        shape = CircleShape
        ) {
        Icon(painter = painterResource(id = drawable), contentDescription ="")
    }
}

@Preview
@Composable
fun PreviewNewCircleButton() {
    val drawable = R.drawable.ic_home
    NewCircleButton(drawable)
}