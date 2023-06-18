package com.example.hammersystemtask.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hammersystemtask.data.db.entities.MealRoomEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MealsDao: CommonDao<MealRoomEntity>() {
    @Query("SELECT * FROM meals WHERE type LIKE '%'||:type||'%'")
    abstract fun getMealsByType(type: String): Flow<List<MealRoomEntity>>

    @Query("SELECT * FROM meals WHERE id = :id")
    abstract suspend fun getMeal(id: String): MealRoomEntity
}