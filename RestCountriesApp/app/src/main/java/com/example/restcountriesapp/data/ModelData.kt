package com.example.restcountriesapp.data

data class ModelData (private val countries: List<String>, private val capitals: List<String>) {

    fun getCapitals(): Map<String, String>
    {
        return countries.zip(capitals).toMap()
    }
}