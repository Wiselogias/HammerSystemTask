package com.example.hammersystemtask.ui.mealsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hammersystemtask.common.adapter.BaseAdapter
import com.example.hammersystemtask.databinding.MealCardBinding


class MealItemAdapter(
) : BaseAdapter<Item, MealViewHolder>(Item.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MealViewHolder (
        MealCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
}