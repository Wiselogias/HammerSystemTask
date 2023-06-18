package com.example.hammersystemtask.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammersystemtask.data.db.dao.MealsDao
import com.example.hammersystemtask.data.db.entities.MealRoomEntity

@Database(
    version = 1,
    entities = [
        MealRoomEntity::class
    ],
    exportSchema = true
)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getMealsDao(): MealsDao
}