package com.example.hammersystemtask.ui.di

import com.example.hammersystemtask.data.di.DataComponent
import com.example.hammersystemtask.ui.displayfragment.DisplayFragment
import com.example.hammersystemtask.ui.main.MainActivity
import com.example.hammersystemtask.ui.menufragment.MenuFragment
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        DataComponent::class
    ]
)
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: DisplayFragment)
    fun inject(fragment: MenuFragment)
}