package com.example.studentcrime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var crimesList =  MutableList(50) { "Crime #$it" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = ListAdapter(this@MainActivity, crimesList)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}