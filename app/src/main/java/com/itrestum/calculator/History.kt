package com.itrestum.calculator

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hist")
data class History(@ColumnInfo(name = "saved_value") val savedValue: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}