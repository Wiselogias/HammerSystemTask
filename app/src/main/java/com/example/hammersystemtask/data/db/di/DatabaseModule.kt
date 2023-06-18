package com.example.hammersystemtask.data.db.di

import android.content.Context
import androidx.room.Room
import com.example.hammersystemtask.data.db.dao.MealsDao
import com.example.hammersystemtask.data.db.database.AppDataBase
import com.example.hammersystemtask.data.di.DataScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    @DataScope
    fun provideDatabase(context: Context): AppDataBase = Room
        .databaseBuilder(context, AppDataBase::class.java, "HammerSystemsTaskDB")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @DataScope
    fun provideMealsDao(appDataBase: AppDataBase): MealsDao = appDataBase.getMealsDao()
}