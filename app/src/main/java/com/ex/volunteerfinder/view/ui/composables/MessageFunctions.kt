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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ex.volunteerfinder.R
import com.ex.volunteerfinder.model.data.*
import com.ex.volunteerfinder.model.data.model.Conversation
import com.ex.volunteerfinder.model.data.model.Message
import com.ex.volunteerfinder.view.ui.theme.VolunteerFinderAppTheme
import com.ex.volunteerfinder.viewmodel.ConversationViewModel
import com.ex.volunteerfinder.viewmodel.factories.ConversationViewModelFactory

@Composable
fun ChatCollectionComposable() {
    val conversationViewModel: ConversationViewModel = viewModel(factory = ConversationViewModelFactory())
    val pencilDrawable = R.drawable.ic_pencil_plus_outline_black_18dp
    val passedList = conversationViewModel.conversations

    VolunteerFinderAppTheme() {

        Scaffold(

            topBar = { SearchBar() },
            bottomBar = { //TODO insert navigator here
            },
            floatingActionButton = { NewCircleButton(pencilDrawable) }
        ) {
            Inbox(list = passedList)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MessageSummary(conversation: Conversation) {

    val mostRecent = conversation.messages.size - 1
    val message = conversation.messages[mostRecent]
    val contact = message.user
    val receiveDate = message.sendTime
    //TODO I'd rather only present a substring UP TO 30 char, but can't hard code 30 (NPE)
    //Is it possible to count the available length given the layout?
    val preview = message.body + "..."

    Card(modifier = Modifier.padding(4.dp),
        elevation = 0.dp,
        onClick = {/*TODO Probably should be passed from parameters*/ }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage() //TODO add padding to ProfileImage
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
fun Inbox(/*Message List, perhaps from data class*/ list: List<Conversation>) {
//TODO there should be a different printout if there are no messages.
    //TODO CHECK HERE FOR NPE!
    /*currently repeats the first card; necessary but unfortunate,
    * as I want to put dividers between each card
    */

    val length = list.size
    list.subList(1, length)

    LazyColumn() {
        item {
            MessageSummary(list[0])
        }
        items(list.size) { index ->
            Divider()
            MessageSummary(list[index])
        }
    }

}

@Composable
fun SearchBar() {

}


@Composable
fun Message(user: User, message: Message) {
    val recipient = user.userName
    val sender = message.user
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