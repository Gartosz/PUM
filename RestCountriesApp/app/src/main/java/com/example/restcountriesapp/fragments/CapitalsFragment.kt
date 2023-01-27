package com.example.restcountriesapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
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

        setupRecyclerView(countriesAdapter)
        observeCountries(countriesAdapter)
    }

    private fun observeCountries(countriesAdapter: Adapter) {
        capitalsViewModel.countries.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { countries ->
                        countriesAdapter.submitList(countries)
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.e(
                            "CapitalsFragment",
                            "Error occurred: $it"
                        )
                    }
                }
                is Resource.Loading -> {
                    Toast.makeText(
                        binding.root.context,
                        "Data is being loaded.", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setupRecyclerView(countriesAdapter: Adapter) {
        binding.capitalsRecyclerView.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}