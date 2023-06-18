package com.example.hammersystemtask.ui.salesadapter

import com.example.hammersystemtask.common.adapter.BaseViewHolder
import com.example.hammersystemtask.databinding.SalesCardBinding

class SaleViewHolder(
    binding: SalesCardBinding
): BaseViewHolder<SaleItem, SalesCardBinding>(binding) {
    override fun bind(model: SaleItem) {
        binding.salesView.setImageResource(model.id)
    }
}