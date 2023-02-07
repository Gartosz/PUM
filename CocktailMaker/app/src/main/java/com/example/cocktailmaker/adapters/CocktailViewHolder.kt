package com.example.cocktailmaker.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaker.databinding.CocktailItemBinding
import com.example.cocktailmaker.models.Cocktail

class CocktailViewHolder (private val binding: CocktailItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cocktail) {
        binding.cocktailName.text = item.name.replace("\"", "")
    }
}