package com.example.cocktailmaker.adapters

import android.R.layout.simple_list_item_1
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaker.R
import com.example.cocktailmaker.databinding.CocktailItemBinding
import com.example.cocktailmaker.models.Cocktail
import com.example.cocktailmaker.models.CocktailViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CocktailViewHolder (private val binding: CocktailItemBinding, private val cocktailViewModel: CocktailViewModel) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cocktail) {
        binding.cocktailName.text = item.name.replace("\"", "")
        handleFavourite(item)
        setLists(item)

    }

    private fun setLists(item: Cocktail) {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String>>() {}.type
        setIngredients(gson, item, type)
        setQuantities(gson, item, type)
        binding.root.setOnClickListener()
        {
            val isExpanded = binding.expandableLayout.visibility == View.VISIBLE
            binding.expandableLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
        }
    }

    private fun setQuantities(
        gson: Gson,
        item: Cocktail,
        type: Type
    ) {
        val quantities: List<String> =
            gson.fromJson<List<String>?>(item.quantities, type).filter { it != null }.toList()
        println(quantities)
        val quantitiesAdapter: ArrayAdapter<String> =
            ArrayAdapter(binding.root.context, simple_list_item_1, quantities)
        binding.quantities.adapter = quantitiesAdapter
    }

    private fun setIngredients(
        gson: Gson,
        item: Cocktail,
        type: Type
    ) {
        val ingredients: List<String> =
            gson.fromJson<List<String>?>(item.ingredients, type).toList()
        val ingredientsAdapter: ArrayAdapter<String> =
            ArrayAdapter(binding.root.context, simple_list_item_1, ingredients)
        binding.ingredients.adapter = ingredientsAdapter
    }

    private fun handleFavourite(item: Cocktail) {
        binding.favouriteButton.setBackgroundResource(if (item.favourite) R.drawable.favourite else R.drawable.not_favourite)
        binding.favouriteButton.setOnClickListener {
            val favourite = !item.favourite
            val updateCocktail =
                Cocktail(item.id, item.name, item.ingredients, item.quantities, favourite)
            cocktailViewModel.update(updateCocktail)
        }
    }
}