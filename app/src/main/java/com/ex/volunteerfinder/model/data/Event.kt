package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Event")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "sponsor")
    var sponsor: String,

    @ColumnInfo(name = "leadership")
    var leadership: MutableList<User>,

    @ColumnInfo(name = "members")
    var members: MutableList<User>,

    @ColumnInfo(name = "address")
    var address: String,

    //Question to be a part of address
    var city: String,
    var state: String,
    var zipCode: Int,

    @ColumnInfo(name = "time")
    var time: Long,

    @ColumnInfo(name = "date")
    var date: Long
    )