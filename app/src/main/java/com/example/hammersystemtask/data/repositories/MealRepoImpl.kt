package com.example.hammersystemtask.data.repositories

import com.example.hammersystemtask.data.db.dao.MealsDao
import com.example.hammersystemtask.data.db.mappers.MealMapper
import com.example.hammersystemtask.domain.entities.MealEntity
import com.example.hammersystemtask.domain.repositories.MealRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MealRepoImpl @Inject constructor(
    private val mealsDao: MealsDao
) : MealRepo {
    override suspend fun getMeal(id: String): MealEntity =
        MealMapper.fromRoomEntityToDomainEntity(mealsDao.getMeal(id))

    override fun getMealsByType(type: String): Flow<List<MealEntity>> =
        mealsDao.getMealsByType(type).map {
            println("jhsvcjdvcjs: " + it)
            it.map { MealMapper.fromRoomEntityToDomainEntity(it) }
        }


    override suspend fun addMeal(mealEntity: MealEntity) {
        mealsDao.upsert(MealMapper.fromDomainEntityToRoomEntity(mealEntity))
    }
}