package com.example.restcountriesapp.models

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.restcountriesapp.data.RetrofitInstance

class ViewModel : ViewModel() {
    private lateinit var countries: List<String>
    private lateinit var capitals: List<String>

    fun getCapitals(): Any
    {
        if (this::capitals.isInitialized && this::countries.isInitialized)
            return countries.zip(capitals).toMap()
        throw UninitializedPropertyAccessException("Capitals or countries list weren't " +
                "initialized from api.")
    }
    fun getFlags(): Any{
        return 0
    }

    suspend fun getFromApi() = RetrofitInstance.api.getCountries()
}