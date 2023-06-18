package com.example.hammersystemtask.ui.salesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hammersystemtask.common.adapter.BaseAdapter
import com.example.hammersystemtask.databinding.SalesCardBinding


class SaleItemAdapter(
): BaseAdapter<SaleItem, SaleViewHolder>(SaleItem.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SaleViewHolder (
        SalesCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
}