package com.example.restcountriesapp.data

import CountriesJSONData
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

interface CountriesApi {
    @GET(data.endpoint)
    fun getCountries(): Call<List<CountriesJSONData>>
}


object Retrofit
{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}