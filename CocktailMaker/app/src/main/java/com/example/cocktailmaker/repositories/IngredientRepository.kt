package com.example.cocktailmaker.repositories

import androidx.lifecycle.LiveData
import com.example.cocktailmaker.data.IngredientDAO
import com.example.cocktailmaker.models.Ingredient

class IngredientRepository (private val ingredientDao : IngredientDAO) {
    val readAllData: LiveData<List<Ingredient>> = ingredientDao.readAllData()

    fun search(query: String): LiveData<Ingredient>
    {
        return ingredientDao.search(query)
    }
}