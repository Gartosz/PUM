package com.example.cocktailmaker.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaker.databinding.IngredientItemBinding
import com.example.cocktailmaker.models.Ingredient

class IngredientViewHolder (private val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Ingredient) {
        binding.ingredientName.text = item.name
    }
}