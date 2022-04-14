package com.ex.volunteerfinder.model.data

object EventDummy {
    var obj = Event (
        name = "Springtime Tallahassee",
        sponsor = "Tallahassee Memorial Hospital",
        leadership = mutableListOf(UserDummy.obj),
        members = mutableListOf(UserDummy.obj),
        address = "1307 N Monroe St",
        city = "Tallahassee",
        state = "FL",
        zipCode = 32303,
        time = 1649939480000
    )
}