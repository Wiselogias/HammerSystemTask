package com.example.hammersystemtask.data.db.mappers

import com.example.hammersystemtask.data.db.entities.MealRoomEntity
import com.example.hammersystemtask.domain.entities.MealEntity

object MealMapper {

    fun fromRoomEntityToDomainEntity(mealRoomEntity: MealRoomEntity): MealEntity = MealEntity(
        id = mealRoomEntity.id,
        name = mealRoomEntity.name,
        description = mealRoomEntity.description,
        type = mealRoomEntity.type,
        image = mealRoomEntity.image,
        price = mealRoomEntity.price
    )

    fun fromDomainEntityToRoomEntity(mealEntity: MealEntity): MealRoomEntity = MealRoomEntity(
        id = mealEntity.id,
        name = mealEntity.name,
        description = mealEntity.description,
        type = mealEntity.type,
        image = mealEntity.image,
        price = mealEntity.price
    )
}