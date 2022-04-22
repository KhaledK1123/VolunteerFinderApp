package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "userName")
    var userName: String?= null,

    @ColumnInfo(name = "password")
    var password: String?= null,

    @ColumnInfo(name ="email")
    var email: String?=null,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name ="city")
    var city: String?= null,

    @ColumnInfo(name = "state")
    var state: String? = null,

    @ColumnInfo(name = "zipCode")
    var zipCode: Int
    )