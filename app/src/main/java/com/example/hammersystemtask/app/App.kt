package com.example.hammersystemtask.app

import android.app.Application
import com.example.hammersystemtask.app.di.AppComponent
import com.example.hammersystemtask.app.di.AppModule
import com.example.hammersystemtask.app.di.DaggerAppComponent
import com.example.hammersystemtask.data.di.DaggerDataComponent
import com.example.hammersystemtask.data.di.DataComponent
import kotlin.properties.Delegates

class   App: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
    val dataComponent: DataComponent by lazy {
        DaggerDataComponent.builder().appComponent(appComponent).build()
    }
}