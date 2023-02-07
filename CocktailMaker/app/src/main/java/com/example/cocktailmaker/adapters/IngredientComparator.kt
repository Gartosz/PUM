package com.example.cocktailmaker.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cocktailmaker.models.Ingredient

class IngredientComparator : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem.name == newItem.name
    }
}