package com.example.restcountriesapp.data

data class CountryCapitalApi(
    val altSpellings: List<String>,
    val capital: List<String>,
    val name: Name
)

data class CountryFlagApi(
    val altSpellings: List<String>,
    val capital: List<String>,
    val flag: String,
    val name: Name
)

data class Name(
    val common: String,
    val nativeName: NativeName,
    val official: String
)

data class NativeName(
    val eng: Eng
)

data class Eng(
    val common: String,
    val official: String
)
