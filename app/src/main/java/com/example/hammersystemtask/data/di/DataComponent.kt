package com.example.hammersystemtask.data.di

import com.example.hammersystemtask.app.di.AppComponent
import com.example.hammersystemtask.data.remote.api.MealsApi
import com.example.hammersystemtask.data.remote.di.RemoteModule
import com.example.hammersystemtask.domain.repositories.MealRepo
import dagger.Component

@DataScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        DataModule::class,
    ]
)
interface DataComponent {
    val mealRepo: MealRepo
    val remoteMealsApi: MealsApi
}