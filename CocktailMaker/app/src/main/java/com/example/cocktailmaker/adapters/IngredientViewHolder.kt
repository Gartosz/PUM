package com.example.cocktailmaker.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaker.databinding.IngredientItemBinding

class IngredientViewHolder (private val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.ingredientName.text = item
    }
}