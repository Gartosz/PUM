package com.example.cocktailmaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailmaker.adapters.CocktailAdapter
import com.example.cocktailmaker.adapters.CocktailComparator
import com.example.cocktailmaker.databinding.FavouritesBinding
import com.example.cocktailmaker.models.Cocktail
import com.example.cocktailmaker.models.CocktailViewModel

class FavouritesFragment : Fragment() {
    private lateinit var binding: FavouritesBinding
    private val cocktailViewModel: CocktailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val adapter = CocktailAdapter(CocktailComparator(), cocktailViewModel)
        binding.favouritesRecyclerView.adapter = adapter
        binding.favouritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        cocktailViewModel.readAllData.observe(viewLifecycleOwner) {
            setFavouriteCocktails(it)
        }
        cocktailViewModel.availableCocktails.observe(viewLifecycleOwner, adapter::submitList)

    }

    private fun setFavouriteCocktails(cocktailsList: List<Cocktail>)
    {
        cocktailViewModel.availableCocktails.value = mutableListOf()
        for (cocktail in cocktailsList)
        {
            if (cocktail.favourite)
                cocktailViewModel.availableCocktails.value?.add(cocktail)
        }
    }
}