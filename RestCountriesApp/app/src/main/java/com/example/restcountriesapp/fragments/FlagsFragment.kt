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
import com.example.restcountriesapp.adapters.Adapter
import com.example.restcountriesapp.adapters.CountriesComparator
import com.example.restcountriesapp.data.data
import com.example.restcountriesapp.databinding.CountriesFlagsBinding
import com.example.restcountriesapp.models.ViewModel
import com.example.restcountriesapp.util.Resource

class FlagsFragment : Fragment() {
    private lateinit var binding: CountriesFlagsBinding

    private val flagsViewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CountriesFlagsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flagsViewModel.getCountries()

        val flagsAdapter = Adapter(CountriesComparator(), data.flags_fragment)

        setupRecyclerView(flagsAdapter)
        observeCountries(flagsAdapter)
    }

    private fun observeCountries(flagsAdapter: Adapter) {
        flagsViewModel.countries.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { countries ->
                        flagsAdapter.submitList(countries)
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.e(
                            "FlagsFragment",
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

    private fun setupRecyclerView(flagsAdapter: Adapter) {
        binding.flagsRecyclerView.apply {
            adapter = flagsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}