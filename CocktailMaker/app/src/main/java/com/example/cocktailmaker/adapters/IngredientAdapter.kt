package com.example.cocktailmaker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cocktailmaker.databinding.IngredientItemBinding
import com.example.cocktailmaker.models.Ingredient

class IngredientAdapter (ingredientComparator: IngredientComparator) : ListAdapter<Ingredient, IngredientViewHolder>(ingredientComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(
            IngredientItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}