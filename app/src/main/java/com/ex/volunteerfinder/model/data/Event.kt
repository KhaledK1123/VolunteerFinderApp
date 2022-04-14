package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "sponsor")
    var sponsor: String,

    @ColumnInfo(name = "leadership")
    var leadership: List<User>,

    @ColumnInfo(name = "members")
    var members: List<User>,

    @ColumnInfo(name = "address")
    var address: String,
    var city: String,
    var state: String,
    var zipCode: Int,

    @ColumnInfo(name = "time")
    var time: Long
    )