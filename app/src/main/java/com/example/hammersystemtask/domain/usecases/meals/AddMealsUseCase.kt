package com.example.hammersystemtask.domain.usecases.meals

import com.example.hammersystemtask.data.db.entities.MealRoomEntity
import com.example.hammersystemtask.data.remote.api.MealsApi
import com.example.hammersystemtask.domain.entities.MealEntity
import com.example.hammersystemtask.domain.repositories.MealRepo
import com.example.hammersystemtask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

class AddMealsUseCase @Inject constructor(
    private val mealRepo: MealRepo,
    private val mealsApi: MealsApi
){
    suspend fun invoke(input: List<String>) = input.forEach {
        try {

            mealsApi.getMealsByFilter(it).meals.map {
                val iter = mealsApi.getMealInfo(it.id).meals.get(0)
                MealEntity(
                    id = mealsApi.getMealInfo(it.id).meals.get(0).id,
                    name = iter.name,
                    description = iter.ingredient1
                            + ", "
                            + iter.ingredient2
                            + ", "
                            + iter.ingredient3
                            + ", "
                            + iter.ingredient4
                            + ", "
                            + iter.ingredient5,
                    image = iter.image,
                    type = iter.type,
                    price = Random.nextInt(300, 1000).toString()
                )
            }.forEach { mealRepo.addMeal(it) }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}