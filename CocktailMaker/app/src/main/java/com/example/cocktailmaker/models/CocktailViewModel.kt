package com.example.cocktailmaker.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailmaker.data.CocktailsDatabase
import com.example.cocktailmaker.repositories.CocktailRepository
import kotlinx.coroutines.launch

class CocktailViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<Cocktail>>
    val availableCocktails : MutableLiveData<MutableList<Cocktail>> = MutableLiveData(mutableListOf())
    private val repository: CocktailRepository

    init {
        val cocktailDao = CocktailsDatabase.getDatabase(application).cocktailDao()
        repository = CocktailRepository(cocktailDao)
        readAllData = repository.readAllData
    }

    fun findFavourites(): LiveData<List<Cocktail>>
    {
        return repository.search(true)
    }

    fun update(item: Cocktail)
    {
        viewModelScope.launch {
            repository.updateItem(item)
        }
    }
}