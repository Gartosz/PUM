package com.example.restcountriesapp.adapters

import CountriesJSONData
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.databinding.ItemBinding

class ViewHolder(private val binding: ItemBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CountriesJSONData){
        binding.countryName.text = item.name.toString()
        binding.countryElement.text = item.capital.toString()
    }
}