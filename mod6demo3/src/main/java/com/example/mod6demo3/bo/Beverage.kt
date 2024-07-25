package com.example.mod6demo3.bo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Beverage(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    val name : String,
    val color : String,
    @ColumnInfo(name = "isAlcoholic")
    val isAlcoholic : Boolean,
    val price : Float
)
