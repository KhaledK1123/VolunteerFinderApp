package com.ex.volunteerfinder.model.data

data class Chat(
    val users: List<User>,
    var messages: MutableList<Message>
)