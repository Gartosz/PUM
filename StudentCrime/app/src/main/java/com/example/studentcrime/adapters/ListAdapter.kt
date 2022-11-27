package com.example.studentcrime.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.studentcrime.R
import com.example.studentcrime.fragments.CrimesListDirections
import java.time.LocalDateTime

class ListAdapter(
    private val crimes: Pair<List<LocalDateTime>, List<Boolean>>
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
        val crimeDate = crimes.first[position]
        val crimeStatus = crimes.second[position]
        holder.crimeTitle.text = "Crime #$position"
        holder.crimeDate.text = crimeDate.toString()
        if (crimeStatus)
            holder.crimeStatus.visibility = View.VISIBLE
        holder.itemView.setOnClickListener {
            val action = CrimesListDirections
                .actionCrimesListToSpecificCrime(
                    index = position
                )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = crimes.first.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val crimeDate: TextView = itemView.findViewById(R.id.singleCrimeDate)
        val crimeTitle: TextView = itemView.findViewById(R.id.singleCrimeTitle)
        val crimeStatus: ImageView = itemView.findViewById(R.id.statusCheckmark)
    }

}