package com.example.restcountriesapp.data

data class ModelData (private val apiLink: String) {
    private lateinit var countries: List<String>
    private lateinit var capitals: List<String>

    fun getCapitals(): Any
    {
        if (this::capitals.isInitialized && this::countries.isInitialized)
            return countries.zip(capitals).toMap()
        throw UninitializedPropertyAccessException("Capitals or countries list weren't " +
                                                   "initialized from api.")
    }
}