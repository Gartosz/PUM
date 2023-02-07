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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailmaker.adapters.IngredientAdapter
import com.example.cocktailmaker.adapters.IngredientComparator
import com.example.cocktailmaker.data.SharedData
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
        setRecyclerView()
    }
}

private fun setRecyclerView()
{
    val adapter = IngredientAdapter(IngredientComparator())
    binding.ingredientsRecyclerView.adapter = adapter
    binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    ingredientViewModel.selectedIngredients.observe(viewLifecycleOwner, adapter::submitList)
}

private fun addAlert() {
    val alert_dialog = AlertDialog.Builder(context)
    val selected = ingredientViewModel.selectedIngredients.value
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
            val selected = textView.text.toString()
            if(selected != "")
            {
                val selectedList = ingredientViewModel.selectedIngredients.value
                selectedList?.add(selected)
                ingredientViewModel.selectedIngredients.postValue(selectedList)
                SharedData.selected_ingredients = selectedList!!.toList()
                binding.ingredientsRecyclerView.adapter?.notifyItemInserted(selectedList.size - 1)
            }
            else
                Toast.makeText(context, "Nothing's been selected!", Toast.LENGTH_SHORT).show()
        }
        setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }
    }.create().show()
}
}