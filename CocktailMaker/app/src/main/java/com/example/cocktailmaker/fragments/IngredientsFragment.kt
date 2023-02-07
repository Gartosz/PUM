package com.example.cocktailmaker.fragments

import android.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cocktailmaker.databinding.IngredientsBinding
import com.example.cocktailmaker.models.IngredientViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class IngredientsFragment : Fragment() {

    private lateinit var binding: IngredientsBinding
    private val ingredientViewModel: IngredientViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = IngredientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        }


}