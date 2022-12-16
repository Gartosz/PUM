package com.example.studenthardlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthardlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        val sharedPref = getSharedPreferences("fileName", MODE_PRIVATE)
        val titles = mutableSetOf("A", "B")
        val edit = sharedPref.edit()
        edit.apply {
            putStringSet("titles", titles)
            apply()
        }
    }
}