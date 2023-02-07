package com.example.cocktailmaker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cocktailmaker.databinding.IngredientItemBinding

class IngredientAdapter (ingredientComparator: IngredientComparator) : ListAdapter<String, IngredientViewHolder>(ingredientComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(
            IngredientItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    public fun getItemAt(position: Int): String{
        return getItem(position)
    }

}