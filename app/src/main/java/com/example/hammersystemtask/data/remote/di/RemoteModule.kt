package com.example.hammersystemtask.data.remote.di

import com.example.hammersystemtask.data.di.DataScope
import com.example.hammersystemtask.data.remote.api.MealsApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class RemoteModule {
    @DataScope
    @Provides
    @Named("server-url")
    fun provideUrl(): String = "https://themealdb.com/"

    @Provides
    @DataScope
    fun provideGson(): Gson = Gson()

    @Provides
    @DataScope
    fun provideRetrofit(@Named("server-url") url: String, gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).build()

    @Provides
    @DataScope
    fun provideMealsApi(retrofit: Retrofit): MealsApi = retrofit.create(MealsApi::class.java)
}