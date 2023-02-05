package com.example.cocktailmaker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cocktailmaker.data.CocktailsDatabase
import com.example.cocktailmaker.repositories.IngredientRepository

class IngredientViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Ingredient>>
    private val repository: IngredientRepository

    init {
        val ingredientDao = CocktailsDatabase.getDatabase(application).ingredientDao()
        repository = IngredientRepository(ingredientDao)
        readAllData = repository.readAllData
    }

    fun search(name: String): LiveData<Ingredient>{
        return repository.search(name)
    }
}