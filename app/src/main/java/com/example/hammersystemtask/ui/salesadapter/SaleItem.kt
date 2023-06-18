package com.example.hammersystemtask.ui.salesadapter

import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import com.example.hammersystemtask.ui.mealsadapter.Item

data class SaleItem (
    @DrawableRes
    val id: Int
        )
{
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SaleItem>() {
            override fun areItemsTheSame(oldItem: SaleItem, newItem: SaleItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SaleItem, newItem: SaleItem): Boolean =
                oldItem == newItem

        }
    }
}