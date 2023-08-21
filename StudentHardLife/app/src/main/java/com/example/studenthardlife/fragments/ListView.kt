package com.example.studenthardlife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studenthardlife.R
import java.lang.IllegalArgumentException

class ListView : Fragment(){
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
        return inflater.inflate(R.layout.list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {

        }
        catch (e: Exception){
            println(e)
        }

    }
}