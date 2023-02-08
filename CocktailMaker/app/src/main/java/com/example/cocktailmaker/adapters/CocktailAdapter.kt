package com.example.cocktailmaker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cocktailmaker.databinding.CocktailItemBinding
import com.example.cocktailmaker.models.Cocktail
import com.example.cocktailmaker.models.CocktailViewModel

class CocktailAdapter (cocktailComparator: CocktailComparator, private val cocktailViewModel: CocktailViewModel) : ListAdapter<Cocktail, CocktailViewHolder>(cocktailComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(CocktailItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), cocktailViewModel)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getItemAt(position: Int): Cocktail{
        return getItem(position)
    }
}