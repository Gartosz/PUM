package com.example.restcountriesapp.data

import retrofit2.Call
import retrofit2.http.GET

interface CountryCapitalApi {
    @GET(data.name_capitals)
    fun getCountries(): Call<List<CountryCapital>>
}

interface CountryFlagApi {
    @GET(data.name_flag)
    fun getCountries(): Call<List<CountryFlag>>
}