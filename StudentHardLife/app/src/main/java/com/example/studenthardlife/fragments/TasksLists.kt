package com.example.studenthardlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthardlife.R
import com.example.studenthardlife.adapters.ListAdapter
import com.example.studenthardlife.data.TasksData
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TasksLists : Fragment() {
    private var lists = TasksData.getLists()
    private lateinit var addListButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ListAdapter(lists)
        addListButton = view.findViewById(R.id.addButton)!!
        addListButton.setOnClickListener()
        {
            
        }
    }
}