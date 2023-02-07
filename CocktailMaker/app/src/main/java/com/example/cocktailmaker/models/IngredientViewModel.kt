package com.example.cocktailmaker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailmaker.data.CocktailsDatabase
import com.example.cocktailmaker.data.SharedData
import com.example.cocktailmaker.repositories.IngredientRepository
import kotlinx.coroutines.launch

class IngredientViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: List<Ingredient>

    var selectedIngredients: MutableLiveData<MutableList<String>> = MutableLiveData(
        mutableListOf()
    )

    private val repository: IngredientRepository

    init {
        val ingredientDao = CocktailsDatabase.getDatabase(application).ingredientDao()
        repository = IngredientRepository(ingredientDao)
        readAllData = repository.readAllData
    }

    fun search(name: String): Ingredient {
        return repository.search(name)
    }

    fun deleteItem(item: String) {
        viewModelScope.launch {
            selectedIngredients.value?.remove(item)
            SharedData.selected_ingredients = selectedIngredients.value!!.toList()
        }
    }
}
