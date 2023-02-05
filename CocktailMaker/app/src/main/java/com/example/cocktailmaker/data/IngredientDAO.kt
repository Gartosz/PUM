package com.example.cocktailmaker.data

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.cocktailmaker.models.Ingredient

interface IngredientDAO {
    @Query("SELECT * FROM ingredients_table WHERE name LIKE :query")
    fun search(query: String): LiveData<List<Ingredient>>

    @Query("SELECT * FROM ingredients_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Ingredient>>
}