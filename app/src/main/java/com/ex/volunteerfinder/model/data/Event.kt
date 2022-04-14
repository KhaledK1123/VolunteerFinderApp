package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo(name = "name")
    var name: String ?= null,
    @ColumnInfo(name = "sponsor")
    var sponsor: String ?= null,

    @ColumnInfo(name = "leadership")
    var leadership: List<User>?=null,

    @ColumnInfo(name = "members")
    var members: List<User>?=null,

    @ColumnInfo(name = "address")
    var address: String?=null,
    var city: String?=null,
    var state: String?=null,
    var zipCode: Int?=null,

    @ColumnInfo(name = "time")
    var time: Long?=null
    )