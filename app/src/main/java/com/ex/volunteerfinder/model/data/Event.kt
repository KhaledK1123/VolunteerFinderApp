package com.ex.volunteerfinder.model.data

data class Event(
    var name: String,
    var sponsor: String,
    var leadership: List<User>,
    var members: List<User>,
    var address: String,
    var city: String,
    var state: String,
    var zipCode: Int,
    var time: Long
        )