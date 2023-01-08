package com.example.studenthardlife.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studenthardlife.R
import com.example.studenthardlife.adapters.ListAdapter
import com.example.studenthardlife.data.TasksData
import com.example.studenthardlife.databinding.TasksListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TasksLists : Fragment() {
    private var lists = TasksData.getLists()
    private lateinit var addListButton: FloatingActionButton
    private lateinit var binding: TasksListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TasksListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListAdapter(lists)
        }
        addNewList(view)
    }

    private fun addNewList(view: View) {
        addListButton = view.findViewById(R.id.addButton)!!
        addListButton.setOnClickListener()
        {
            setNewListTitle()
        }
    }

    private fun setNewListTitle() {
        val alertDialog = AlertDialog.Builder(context)
        val input = EditText(context)
        input.inputType = InputType.TYPE_CLASS_TEXT
        setupAlert(alertDialog, input)
    }

    private fun setupAlert(
        alertDialog: AlertDialog.Builder,
        input: EditText
    ) {
        alertDialog.apply {
            setTitle("Set Title")
            setView(input)
            setPositiveButton("Create") { _: DialogInterface?, _: Int ->
                val title = input.text.toString()
                if (title != "")
                {
                    TasksData.addList(input.text.toString())
                    lists = TasksData.getLists()
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                    binding.recyclerView.refreshDrawableState()
                }
                else
                    Toast.makeText(context, "Title can't be empty!", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
        }.create().show()
    }
}