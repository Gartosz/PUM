package com.example.restcountriesapp.data

data class ModelData (private val apiLink: String) {
    private lateinit var countries: List<String>
    private lateinit var capitals: List<String>

    fun getCapitals(): Any
    {
        return countries.zip(capitals).toMap()
    }
}