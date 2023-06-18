package com.example.hammersystemtask.common.mvvm

import androidx.fragment.app.Fragment

interface FragmentComponent<T : Fragment> {
    fun inject(fragment: T)
}