package com.example.studentcrime.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.studentcrime.R
import com.example.studentcrime.fragments.CrimesListDirections

class ListAdapter(
    private val crimesList: MutableList<String>
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.crime_item,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val crime = crimesList[position]
        holder.crime.text = crime
        holder.itemView.setOnClickListener {
            val action = CrimesListDirections
                .actionCrimesListToSpecificCrime(
                    index = position
                )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = crimesList.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val crime: TextView = itemView.findViewById((R.id.singleCrime))
    }

}