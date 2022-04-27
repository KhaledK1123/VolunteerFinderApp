package com.ex.volunteerfinder.model.data.model

data class ApiEvent(
    val id: Int,
    val name: String,
    val sponsor: String,
    val leadership: List<String>,
    val members: List<String>,
    val address: String,
    val city: String,
    val zipCode: Int,
    val time: Long,
    val posts: List<Message>
)