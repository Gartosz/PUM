package com.example.cocktailmaker.repositories

import com.example.cocktailmaker.data.IngredientDAO
import com.example.cocktailmaker.models.Ingredient

class IngredientRepository (private val ingredientDao : IngredientDAO) {
    val readAllData: List<Ingredient> = ingredientDao.readAllData()

    fun search(query: String): Ingredient
    {
        return ingredientDao.search(query)
    }
}