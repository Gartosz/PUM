package com.example.studentcrime.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.studentcrime.R
import com.example.studentcrime.data.CrimesData
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            val detailedCrime = CrimesData.getDetailedCrime(index)
            view.findViewById<TextView>(R.id.specificCrimeTitle).text = detailedCrime["Title"].toString()
            view.findViewById<TextView>(R.id.specificCrimeDate).text = "Czas zgłoszenia: " +
                    detailedCrime["Datetime"].toString()
            view.findViewById<TextView>(R.id.specificCrimeDescription).text = "Opis " +
                    detailedCrime["Description"].toString()
            view.findViewById<TextView>(R.id.specificCrimeStudentID).text = "Indeks studenta: " +
                    detailedCrime["Student Index"].toString()
            if (detailedCrime["Status"] == true)
                view.findViewById<ImageView>(R.id.specificCrimeStatus).visibility = View.VISIBLE
        }
        catch (e: Exception){
            println(e)
        }


    }
}