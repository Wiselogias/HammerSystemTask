package com.example.hammersystemtask.ui.mealsadapter

import com.example.hammersystemtask.domain.entities.MealEntity

object ItemMapper {
    fun fromDomainEntityToMapper(mealEntity: MealEntity) = Item(
        id = mealEntity.id,
        title = mealEntity.name,
        description = mealEntity.description,
        imageRef = mealEntity.image,
        price = mealEntity.price
    )
}