package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "sponsor")
    var sponsor: String? = null,

    @ColumnInfo(name ="leadership")
    var leadership:String? = null,

    @ColumnInfo(name = "address")
    var address: String? = null,

    @ColumnInfo(name = "city")
    var city: String? = null,

    @ColumnInfo(name = "state")
    var state: String? = null,

    @ColumnInfo(name = "Zip Code")
    var zipCode: Int? = null,

    @ColumnInfo(name = "time")
    var time: Long? = null
)