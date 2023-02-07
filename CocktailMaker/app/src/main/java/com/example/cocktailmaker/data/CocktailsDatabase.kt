package com.example.cocktailmaker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktailmaker.models.Ingredient
import com.example.cocktailmaker.models.Cocktail

@Database(entities = [Ingredient::class, Cocktail::class], version = 1, exportSchema = false)
abstract class CocktailsDatabase : RoomDatabase() {
    abstract fun ingredientDao(): IngredientDAO
    abstract fun cocktailDao(): CocktailDAO

    companion object{
        @Volatile private var INSTANCE: CocktailsDatabase? = null

        fun getDatabase(context: Context): CocktailsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailsDatabase::class.java,
                    "cocktails_database"
                ).createFromAsset("database/cocktails.db").allowMainThreadQueries()
                    .build().also { INSTANCE = it }
                instance
            }
        }
    }
}