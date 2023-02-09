package com.example.cocktailmaker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailmaker.adapters.CocktailAdapter
import com.example.cocktailmaker.adapters.CocktailComparator
import com.example.cocktailmaker.data.SharedData
import com.example.cocktailmaker.databinding.CocktailsBinding
import com.example.cocktailmaker.models.Cocktail
import com.example.cocktailmaker.models.CocktailViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CocktailsFragment : Fragment() {
    private lateinit var binding: CocktailsBinding
    private val cocktailViewModel: CocktailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        Toast.makeText(context, "Click on cocktail to show ingredients. Hold to search " +
                "in the web browser. Click on the hearth to add to favourites. ", Toast.LENGTH_LONG).show()
    }

    private fun setRecyclerView()
    {
        val adapter = CocktailAdapter(CocktailComparator(), cocktailViewModel)
        binding.cocktailsRecyclerView.adapter = adapter
        binding.cocktailsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        cocktailViewModel.readAllData.observe(viewLifecycleOwner) {
            setAvailableCocktails(it)
        }
        cocktailViewModel.availableCocktails.observe(viewLifecycleOwner, adapter::submitList)

    }

    private fun setAvailableCocktails(cocktailsList: List<Cocktail>)
    {
        cocktailViewModel.availableCocktails.value = mutableListOf()
        for (cocktail in cocktailsList)
        {
            if (checkCocktail(cocktail))
                cocktailViewModel.availableCocktails.value?.add(cocktail)
        }
    }

    private fun checkCocktail(item: Cocktail) : Boolean
    {
        val gson = Gson()
        val ingredients: List<String>
        val type: Type = object : TypeToken<List<String>>() {}.type
        ingredients = gson.fromJson<List<String>?>(item.ingredients, type).toList()
        if (SharedData.selected_ingredients.containsAll(ingredients))
            return true
        return false
    }
}