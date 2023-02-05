package com.example.cocktailmaker.models

import androidx.room.Entity

@Entity(tableName = "cocktails_table")
data class Cocktail (
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val favourite: Boolean
)