package com.ex.volunteerfinder.model.data

/* Not certain if THIS file needs to resemble 'MyEvent' data class, in terms of structure, OR
if THIS structure will capture profile data the best (similar to that of 'Message' data class) */

data class VolunteerProfile(
    var id: Long,
    var userName: String,
    var password: String,
    var email: String,
    var name: String,
    var city: String,
    var state: String,
    var zipCode: Int

)
