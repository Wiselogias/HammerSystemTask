package com.example.hammersystemtask.ui.mealsadapter

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.example.hammersystemtask.R
import com.example.hammersystemtask.common.adapter.BaseViewHolder
import com.example.hammersystemtask.databinding.MealCardBinding


class MealViewHolder(
    binding: MealCardBinding
) : BaseViewHolder<Item, MealCardBinding>(binding) {
    @SuppressLint("SetTextI18n")
    override fun bind(model: Item) {
        binding.mealName.text = model.title
        binding.descriptionName.text = model.description
        binding.price.text = model.price + " р"
        if (model.imageRef.isEmpty()) {
            binding.imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            binding.imageView.setImageDrawable(
                AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.round_hide_image_24
                )
            )
        } else {
            binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide
                .with(binding.imageView)
                .load(model.imageRef)
                .centerCrop()
                .into(binding.imageView)
        }

    }

}