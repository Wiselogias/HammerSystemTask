package com.example.hammersystemtask.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealRoomEntity (
    @PrimaryKey
    val id: String,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val description: String,
    @ColumnInfo
    val image: String,
    @ColumnInfo
    val type: String,
    @ColumnInfo
    val price: String
)