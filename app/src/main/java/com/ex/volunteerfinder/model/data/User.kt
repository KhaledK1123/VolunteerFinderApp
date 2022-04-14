package com.ex.volunteerfinder.model.data

data class User (
    var id: Long,
    var userName: String,
    var password: String,
    var email: String,
    var name: String,
    var city: String,
    var state: String,
    var zipCode: Int
        )