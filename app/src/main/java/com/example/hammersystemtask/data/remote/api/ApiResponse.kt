package com.example.hammersystemtask.data.remote.api

import com.google.gson.annotations.SerializedName

data class MealsListResponse (
    @SerializedName("meals")
    val meals: List<ShortMealResponse>
    )

data class ShortMealResponse(
    @SerializedName("idMeal")
    val id: String
)

data class PreFullMealResponse(
    @SerializedName("meals")
    val meals: List<FullMealResponse>
)

data class FullMealResponse(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strCategory")
    val type: String,
    @SerializedName("strIngredient1")
    val ingredient1: String,
    @SerializedName("strIngredient2")
    val ingredient2: String,
    @SerializedName("strIngredient3")
    val ingredient3: String,
    @SerializedName("strIngredient4")
    val ingredient4: String,
    @SerializedName("strIngredient5")
    val ingredient5: String,
    @SerializedName("strMealThumb")
    val image: String
)