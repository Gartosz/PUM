package com.example.studentcrime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.studentcrime.R
import java.lang.IllegalArgumentException

class DetailedCrime : Fragment() {

    private val index by lazy {
        arguments?.getInt("index")?:
        throw IllegalArgumentException("index doesn't exist")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.specific_crime_item, container, false)
    }
}