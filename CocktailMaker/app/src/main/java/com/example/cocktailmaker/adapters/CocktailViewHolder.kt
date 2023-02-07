package com.example.cocktailmaker.adapters

import android.R.layout.simple_list_item_1
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailmaker.databinding.CocktailItemBinding
import com.example.cocktailmaker.models.Cocktail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CocktailViewHolder (private val binding: CocktailItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cocktail) {
        binding.cocktailName.text = item.name.replace("\"", "")
        val gson = Gson()
        val type: Type = object : TypeToken<List<String>>() {}.type
        val ingredients: List<String> = gson.fromJson<List<String>?>(item.ingredients, type).toList()
        val ingredientsAdapter : ArrayAdapter<String> = ArrayAdapter(binding.root.context, simple_list_item_1, ingredients)
        binding.ingredients.adapter = ingredientsAdapter

        val quantities: List<String> = gson.fromJson<List<String>?>(item.quantities, type).filter { it != null }.toList()
        println(quantities)
        val quantitiesAdapter : ArrayAdapter<String> = ArrayAdapter(binding.root.context, simple_list_item_1, quantities)
        binding.quantities.adapter = quantitiesAdapter
        binding.root.setOnClickListener()
        {
            val isExpanded = binding.expandableLayout.visibility == View.VISIBLE
            binding.expandableLayout.visibility = if (isExpanded) View.GONE else View.VISIBLE
        }

    }
}