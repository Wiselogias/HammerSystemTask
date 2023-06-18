package com.example.hammersystemtask.ui.displayfragment

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.hammersystemtask.R
import com.example.hammersystemtask.common.mvvm.BaseFragment
import com.example.hammersystemtask.databinding.DisplayFragmentBinding
import com.example.hammersystemtask.ui.fragmentpageadapter.FragmentPageAdapter
import com.example.hammersystemtask.ui.main.MainActivity
import com.example.hammersystemtask.ui.salesadapter.SaleItem
import com.example.hammersystemtask.ui.salesadapter.SaleItemAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class DisplayFragment: BaseFragment<MainActivity>() {
    @Inject
    lateinit var viewModel: DisplayViewModel

    private lateinit var binding: DisplayFragmentBinding

    private val adapter by lazy {
        FragmentPageAdapter(childFragmentManager, lifecycle, viewModel.tabs)
    }

    private val salesAdapter by lazy {
        SaleItemAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity.activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplayFragmentBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = adapter

        binding.salesView.adapter = salesAdapter

        salesAdapter.items = listOf(SaleItem(R.drawable.sale_one), SaleItem(R.drawable.sale_two))
        TabLayoutMediator(binding.tabsLayout, binding.viewPager) { tab, position ->
            tab.text = viewModel.tabs[position]
        }.attach()
        return binding.root
    }
}