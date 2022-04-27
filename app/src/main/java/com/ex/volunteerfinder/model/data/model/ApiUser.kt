package com.ex.volunteerfinder.model.data.model

data class ApiUser(
    val city: String,
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val state: String,
    val username: String,
    val zipcode: Int
)