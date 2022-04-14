package com.ex.volunteerfinder.model.data

data class Message (
    val body: String,
    val sendTime: Long,
    val users: List<User>
        )