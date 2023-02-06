package com.example.cocktailmaker.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients_table")
data class Ingredient (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)