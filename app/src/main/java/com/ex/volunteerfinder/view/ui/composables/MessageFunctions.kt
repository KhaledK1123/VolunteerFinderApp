package com.ex.volunteerfinder.view.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.*
import com.ex.volunteerfinder.model.data.model.Conversation
import com.ex.volunteerfinder.model.data.model.Message
import com.ex.volunteerfinder.view.NavigationItem
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme

@Composable
fun ChatCollectionComposable(conversations: List<Conversation>, navController: NavHostController) {

    val pencilDrawable = R.drawable.ic_pencil_plus_outline_black_18dp

    VolunteerFinderAppTheme() {

        Scaffold(
//            floatingActionButton = { NewCircleButton(pencilDrawable) }
        ) {
            Inbox(conversationList = conversations, navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConversationSummary(id: Int, conversation: Conversation, navController: NavHostController) {

    val mostRecent = conversation.messages.size - 1
    val message = conversation.messages[mostRecent]
    val contact = message.user
    val receiveDate = message.sendTime
    //Is it possible to count the available length given the layout?
    val preview = message.body + "..."

    Card(modifier = Modifier.padding(4.dp),
        elevation = 0.dp,
        onClick = {
            navController.navigate(NavigationItem.Conversation.withArgs(id.toString()))
        }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage()
            Column(modifier = Modifier.padding(4.dp)) {
                contact.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = preview,
                    fontSize = 12.sp
                )
                Text(
                    text = receiveDate.toString(),
                    fontSize = 10.sp,
                    color = Color.LightGray
                )
            }
        }
    }
}

@Composable
fun Inbox(conversationList: List<Conversation>, navController: NavHostController) {

    val length = conversationList.size

    LazyColumn() {
        items(conversationList.size) { index ->
            Divider()
            ConversationSummary(index, conversationList[index], navController)
        }
    }

}

@Composable
fun SearchBar() {

}

@Composable
fun Conversation (conversation: Conversation) {
//    val thisConversation = inbox[conversationId]

}

@Composable
fun Message(message: Message) {
//    val recipient = user.userName
//    val sender = message.user
//    val recipientBoolean = (recipient == message.user)

}

@Preview
@Composable
fun MessageSummaryPreview() {
//    MessageSummary()
}

@Preview
@Composable
fun InboxPreview() {
    val obj = Message(
        body = "John Madden John Madden John Madden",
        sendTime = 1649939435935,
        user = "JohnMan"
    )
    val previewList = listOf(MessageDummy.obj, obj, MessageDummy.obj)
//    Inbox(list = previewList)
}