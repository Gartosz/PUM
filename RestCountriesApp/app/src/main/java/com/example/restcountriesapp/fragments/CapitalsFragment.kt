package com.example.restcountriesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.restcountriesapp.R
import com.example.restcountriesapp.adapters.Adapter
import com.example.restcountriesapp.adapters.CountriesComparator
import com.example.restcountriesapp.data.data
import com.example.restcountriesapp.databinding.CountriesCapitalsBinding
import com.example.restcountriesapp.models.ViewModel
import com.example.restcountriesapp.util.Resource

class CapitalsFragment : Fragment() {
    private lateinit var binding: CountriesCapitalsBinding

    private val capitalsViewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.countries_capitals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        capitalsViewModel.getCountries()

        val countriesAdapter = Adapter(CountriesComparator(), data.capitals_fragment)
    }
}