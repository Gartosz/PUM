package com.example.studenthardlife.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.studenthardlife.R
import com.example.studenthardlife.data.ListElement
import com.example.studenthardlife.data.TasksData
import com.example.studenthardlife.fragments.TasksListsDirections

class ListAdapter(
    private val lists: List<ListElement>
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_view,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            val action = TasksListsDirections
                .actionTasksListsToListView(
                    index = position
                )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = lists.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        }

}