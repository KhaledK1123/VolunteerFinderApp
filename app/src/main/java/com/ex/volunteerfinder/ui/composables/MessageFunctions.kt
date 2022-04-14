package com.ex.volunteerfinder.ui.composables

import androidx.compose.runtime.Composable
import com.ex.volunteerfinder.model.data.Message
import com.ex.volunteerfinder.model.data.UserDummy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MessageSummary (message: Message) {

    val contact = message.users[1]
    val receiveDate = message.sendTime
    //I'd rather only present a substring UP TO 30 char, but can't hard code 30 (NPE)
    val preview = message.body + "..."

    Row {
        ProfileImage()
        Column {
            Text (text = contact.userName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text (text = preview,
                fontSize = 12.sp
            )
//            Text (text = receiveDate)
//            Text(text = receiveDate,
//                fontSize = 10.sp
//            )
        }
    }

}