package com.ex.volunteerfinder.model.data

data class User (
    val id: Long,
    var userName: String,
    var password: String,
    var email: String,
    var city: String,
    var state: String,
    var zipCode: Int
        )