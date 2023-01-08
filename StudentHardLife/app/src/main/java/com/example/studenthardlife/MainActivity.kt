package com.example.studenthardlife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studenthardlife.data.TasksData
import com.example.studenthardlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TasksData.setupSharedPreferences(this)
        setContentView(binding.root)
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