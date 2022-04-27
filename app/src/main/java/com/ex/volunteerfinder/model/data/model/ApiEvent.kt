package com.ex.volunteerfinder.model.data.model

data class ApiEvent(
    val address: String,
    val city: String,
    val id: Int,
    val leadership: List<String>,
    val members: List<String>,
    val name: String,
    val sponsor: String,
    val time: Long,
    val zipCode: Int,
    val postList: List<Message>
)