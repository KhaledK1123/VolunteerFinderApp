package com.ex.volunteerfinder.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ex.volunteerfinder.view.ui.newPasswordInput

@Entity(tableName= "passwords")
data class Passwords (
    @PrimaryKey(autoGenerate = true)
    val email: String?=null,

    @ColumnInfo(name = "password")
    var password: String?= null,
    )
