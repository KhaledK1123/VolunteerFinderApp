package com.ex.volunteerfinder.view.ui.composables

import androidx.compose.runtime.Composable
import com.ex.volunteerfinder.model.data.Message
import com.ex.volunteerfinder.model.data.UserDummy

@Composable
fun MessageSummary (message: Message) {

    val contact = message.users[1]
    val receiveDate = message.sendTime
    val preview = message.body.substring(0,30) + "..."

}