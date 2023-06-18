package com.example.hammersystemtask.data.di

import com.example.hammersystemtask.data.db.di.DatabaseModule
import com.example.hammersystemtask.data.remote.di.RemoteModule
import com.example.hammersystemtask.data.repositories.MealRepoImpl
import com.example.hammersystemtask.domain.repositories.MealRepo
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DatabaseModule::class,
        RemoteModule::class
    ]
)
abstract class DataModule {
    @Binds
    @DataScope
    abstract fun bindMealRepo(mealRepoImpl: MealRepoImpl): MealRepo
}