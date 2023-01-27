package com.example.restcountriesapp.adapters

import CountriesJSONData
import androidx.recyclerview.widget.DiffUtil

class CountriesComparator : DiffUtil.ItemCallback<CountriesJSONData>(){
    override fun areItemsTheSame(oldItem: CountriesJSONData, newItem: CountriesJSONData): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CountriesJSONData, newItem: CountriesJSONData): Boolean {
        return oldItem == newItem
    }
}