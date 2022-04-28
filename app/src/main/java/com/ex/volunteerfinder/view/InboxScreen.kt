package com.ex.volunteerfinder.view

sealed class InboxScreen (val route: String) {

    object Inbox: InboxScreen(route = "inbox")
    object Message: InboxScreen(route = "message")
}