package com.example.restcountriesapp.adapters

import CountriesJSONData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.restcountriesapp.databinding.ItemBinding

class Comparator : DiffUtil.ItemCallback<CountriesJSONData>(){
    override fun areItemsTheSame(oldItem: CountriesJSONData, newItem: CountriesJSONData): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(
        oldItem: CountriesJSONData,
        newItem: CountriesJSONData
    ): Boolean {
        TODO("Not yet implemented")
    }

}