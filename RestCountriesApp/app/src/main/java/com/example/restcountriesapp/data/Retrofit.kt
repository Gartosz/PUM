package com.example.restcountriesapp.data

import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

interface CountryCapitalApi {
    @GET(data.name_capitals)
    fun getCountries(): Call<List<CountryCapital>>
}

interface CountryFlagApi {
    @GET(data.name_flag)
    fun getCountries(): Call<List<CountryFlag>>
}

object Retrofit
{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}