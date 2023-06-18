package com.example.hammersystemtask.ui.fragmentpageadapter

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hammersystemtask.ui.menufragment.MenuFragment


class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabs: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment {
        val fragment = MenuFragment()
        fragment.arguments = bundleOf("type" to tabs[position])
        return fragment
    }

}