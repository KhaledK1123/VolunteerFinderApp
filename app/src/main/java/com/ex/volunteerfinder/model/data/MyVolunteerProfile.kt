package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "volunteer profile")
data class MyVolunteerProfile(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "username")
    var userName: String?= null,

    @ColumnInfo(name = "password")
    var password: String?= null,

    @ColumnInfo(name = "volunteer name")
    var name: String?= null,

    @ColumnInfo(name = "city")
    var city: String?= null,

    @ColumnInfo(name = "state")
    var state: String?= null,

    @ColumnInfo(name = "zip code")
    var zipCode: Long?= 0

)
