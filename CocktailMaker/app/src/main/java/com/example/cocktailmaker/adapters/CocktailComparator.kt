package com.example.cocktailmaker.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cocktailmaker.models.Cocktail

class CocktailComparator : DiffUtil.ItemCallback<Cocktail>(){
    override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
        return oldItem.name == newItem.name && oldItem.ingredients == newItem.ingredients

    }
}