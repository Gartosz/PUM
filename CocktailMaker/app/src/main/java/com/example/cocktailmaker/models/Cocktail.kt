package com.example.cocktailmaker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails_table")
data class Cocktail (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val favourite: Boolean
)