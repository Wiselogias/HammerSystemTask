package com.example.hammersystemtask.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hammersystemtask.R
import com.example.hammersystemtask.common.mvvm.BaseActivity
import com.example.hammersystemtask.databinding.ActivityMainBinding
import com.example.hammersystemtask.ui.di.DaggerMainActivityComponent
import com.example.hammersystemtask.ui.di.MainActivityComponent


class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding


    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.builder().dataComponent(component).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityComponent.inject(this)
        binding.navBar.selectedItemId = R.id.action_menu

    }


}