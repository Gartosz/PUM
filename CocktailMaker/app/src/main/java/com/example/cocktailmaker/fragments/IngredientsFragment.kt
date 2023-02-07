package com.example.cocktailmaker.fragments

import android.R.layout.simple_dropdown_item_1line
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
import com.example.cocktailmaker.databinding.IngredientDialogBinding
import com.example.cocktailmaker.databinding.IngredientsBinding
import com.example.cocktailmaker.models.IngredientViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class IngredientsFragment : Fragment() {

    private lateinit var binding: IngredientsBinding
    private lateinit var fragmentInflater: LayoutInflater
    private lateinit var fragmentContainer: ViewGroup
    private lateinit var addListButton: FloatingActionButton
    private val ingredientViewModel: IngredientViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = IngredientsBinding.inflate(inflater, container, false)
        fragmentInflater = inflater
        fragmentContainer = container!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            addIngredient()
        }

private fun addIngredient() {
    addListButton =  binding.addButton
    addListButton.setOnClickListener()
    {
        addAlert()
    }
}

private fun addAlert() {
    val alert_dialog = AlertDialog.Builder(context)
    val selected = ingredientViewModel.selectedIngredients.value?.map{ it.name }
    val available = ingredientViewModel.readAllData.map{ it.name }.toMutableList()
    available.removeAll(selected!!)
    val dialog_adapter: ArrayAdapter<String> = ArrayAdapter<String>(
        requireContext(),
        simple_dropdown_item_1line,
        available )
    setupAlert(alert_dialog, dialog_adapter)
}

private fun setupAlert(
    alertDialog: AlertDialog.Builder,
    elements: ArrayAdapter<String>
) {
    val dialogBinding = IngredientDialogBinding.inflate(fragmentInflater, fragmentContainer, false)
    val textView: AutoCompleteTextView = dialogBinding.chooseIngredient
    textView.setAdapter(elements)

    alertDialog.apply {
        setTitle("Add ingredient")
        setView(dialogBinding.root)
        setPositiveButton("Add") { _: DialogInterface?, _: Int ->

        }
        setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }
    }.create().show()
}
}