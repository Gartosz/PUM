package com.example.studenthardlife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthardlife.data.ListElement
import com.example.studenthardlife.data.TasksData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(TasksData.getLists())
        val edit = sharedPref.edit()
        edit.apply {
            putString("Tasks", json)
            apply()
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        val arrayItems: List<ListElement>
        val serializedObject: String? = sharedPref.getString("Tasks", null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<ListElement>>() {}.type
            arrayItems = gson.fromJson(serializedObject, type)
            TasksData.importLists(arrayItems)
        }
    }


}