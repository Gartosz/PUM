package com.example.restcountriesapp.models

import CountriesResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcountriesapp.data.RetrofitInstance
import com.example.restcountriesapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel : ViewModel() {
    private val _countries: MutableLiveData<Resource<CountriesResponse>> = MutableLiveData()

    val countries: LiveData<Resource<CountriesResponse>>
        get() = _countries

    fun getCountries() = viewModelScope.launch {
        _countries.postValue(Resource.Loading())
        val response = getFromApi()
        _countries.postValue(handleCountriesResponse(response))
    }

    private fun handleCountriesResponse(response: Response<CountriesResponse>)
            : Resource<CountriesResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())
    }

    suspend fun getFromApi() = RetrofitInstance.api.getCountries()
}