package com.example.studenthardlife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthardlife.data.TasksData
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(TasksData.getLists())
        val edit = sharedPref.edit()
        edit.apply {
            putString("Tasks", json)
            apply()
        }
    }
}