package com.example.cocktailmaker.repositories

import androidx.lifecycle.LiveData
import com.example.cocktailmaker.data.CocktailDAO
import com.example.cocktailmaker.models.Cocktail

class CocktailRepository (private val cocktailDAO: CocktailDAO) {
    val readAllData: LiveData<List<Cocktail>> = cocktailDAO.readAllData()

    fun search(favourite: Boolean): LiveData<List<Cocktail>>
    {
        return cocktailDAO.search(favourite)
    }

    suspend fun updateItem(item: Cocktail)
    {
        cocktailDAO.updateItem(item)
    }
}