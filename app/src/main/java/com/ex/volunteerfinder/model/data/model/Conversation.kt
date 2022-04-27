package com.ex.volunteerfinder.model.data.model

import com.ex.volunteerfinder.model.data.User

data class Conversation (
    val users: List<String>,
    val messages: List<Message>
        )