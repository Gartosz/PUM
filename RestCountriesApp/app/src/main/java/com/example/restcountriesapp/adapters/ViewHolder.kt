package com.example.restcountriesapp.adapters

import CountriesJSONData
import androidx.recyclerview.widget.RecyclerView
import com.example.restcountriesapp.data.data
import com.example.restcountriesapp.databinding.ItemBinding

class ViewHolder(private val binding: ItemBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CountriesJSONData, fragmentName: String){
        binding.countryName.text = item.name.common
        if (fragmentName == data.capitals_fragment)
            binding.countryElement.text = item.capital.toString().replace("[", "").replace("]", "")
        else if (fragmentName == data.flags_fragment)
            binding.countryElement.text = item.flag
    }
}