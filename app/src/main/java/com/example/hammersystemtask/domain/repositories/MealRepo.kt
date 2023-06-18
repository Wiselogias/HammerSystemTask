package com.example.hammersystemtask.domain.repositories

import com.example.hammersystemtask.domain.entities.MealEntity
import kotlinx.coroutines.flow.Flow

interface MealRepo {
    suspend fun getMeal(id: String): MealEntity
    fun getMealsByType(type: String): Flow<List<MealEntity>>
    suspend fun addMeal(mealEntity: MealEntity)
}