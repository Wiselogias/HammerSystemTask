package com.example.hammersystemtask.app.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    @AppScope
    fun provideContext(): Context = context
}