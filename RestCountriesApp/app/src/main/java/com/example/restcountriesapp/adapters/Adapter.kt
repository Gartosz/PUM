package com.example.restcountriesapp.adapters

import CountriesJSONData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.restcountriesapp.databinding.ItemBinding

class Adapter(itemCountriesComparator: CountriesComparator, private val fragmentName: String) : ListAdapter<CountriesJSONData, ViewHolder>(itemCountriesComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, fragmentName)
    }
}