package com.example.hammersystemtask.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealsByFilter(
        @Query("c") filter: String
    ): MealsListResponse

    @GET("/api/json/v1/1/lookup.php")
    suspend fun getMealInfo(
        @Query("i") filter: String
    ): PreFullMealResponse
}