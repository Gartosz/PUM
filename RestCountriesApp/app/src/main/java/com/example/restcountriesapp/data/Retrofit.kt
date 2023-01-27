package com.example.restcountriesapp.data

import CountriesJSONData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

interface CountriesApi {
    @GET(data.endpoint)
    suspend fun getCountries(): Response<ArrayList<CountriesJSONData>>
}


object RetrofitInstance
{
    val api: CountriesApi by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(data.api_link)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CountriesApi::class.java)
    }
}