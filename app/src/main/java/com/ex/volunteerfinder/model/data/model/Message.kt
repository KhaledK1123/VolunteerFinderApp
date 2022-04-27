package com.ex.volunteerfinder.model.data.model

import com.ex.volunteerfinder.model.data.User

data class Message(
    val body: String,
    val sendTime: Long,
    val user: String
        )