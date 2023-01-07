package com.example.studenthardlife.data

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object TasksData {
    private var listsElements = mutableListOf<ListElement>()
    private lateinit var sharedPref: SharedPreferences

    fun setupSharedPreferences(context: Context)
    {
        sharedPref = context.getSharedPreferences("fileName", AppCompatActivity.MODE_PRIVATE)
        loadData()
    }

    fun getLists(): List<ListElement>
    {
        return listsElements.toList()
    }

    fun addList(title: String)
    {
        val newList = ListElement(title)
        listsElements.add(newList)
        saveData()
    }

    fun saveData()
    {
        val gson = Gson()
        val json = gson.toJson(getLists())
        val edit = sharedPref.edit()
        edit.apply {
            putString("Tasks", json)
            apply()
        }
    }

    fun loadData()
    {
        val arrayItems: List<ListElement>
        val serializedObject: String? = sharedPref.getString("Tasks", null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<ListElement>>() {}.type
            arrayItems = gson.fromJson(serializedObject, type)
            listsElements = arrayItems.toMutableList()
        }
    }
}