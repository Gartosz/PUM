package com.example.cocktailmaker.models

import androidx.room.Entity

@Entity(tableName = "ingredients_table")
data class Ingredient (
    val id: Int,
    val name: String
)