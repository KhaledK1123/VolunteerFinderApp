package com.ex.volunteerfinder.model.data

data class Conversation (
    val users: List<User>,
    val messages: List<Message>
        )