package com.ex.volunteerfinder.model.data

data class Event(
    var name: String,
    var sponsor: String,
    var leadership: MutableList<User>,
    var members: MutableList<User>,
    var address: String,
    var city: String,
    var state: String,
    var zipCode: Int,
    var time: Long,
    var date: Long
        )