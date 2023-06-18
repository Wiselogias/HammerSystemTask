package com.example.hammersystemtask.domain.usecases.meals

import com.example.hammersystemtask.domain.entities.MealEntity
import com.example.hammersystemtask.domain.repositories.MealRepo
import com.example.hammersystemtask.domain.usecases.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMealsByTypeUseCase @Inject constructor(
    private val mealRepo: MealRepo
): UseCase<String, List<MealEntity>> {
    override fun invoke(input: String): Flow<List<MealEntity>> = mealRepo.getMealsByType(input)
}