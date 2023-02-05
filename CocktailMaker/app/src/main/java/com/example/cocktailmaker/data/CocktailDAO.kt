package com.example.cocktailmaker.data

import androidx.lifecycle.LiveData
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cocktailmaker.models.Cocktail

interface CocktailDAO {
    @Query("SELECT * FROM cocktails_table WHERE id LIKE :favourite")
    fun search(favourite: Boolean): LiveData<List<Cocktail>>

    @Query("SELECT * FROM cocktails_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Cocktail>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateItem(item: Cocktail)
}