package com.example.studenthardlife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthardlife.data.TasksData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TasksData.setupSharedPreferences(this)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        TasksData.saveData()
    }

    override fun onResume() {
        super.onResume()
        TasksData.loadData()
    }
}