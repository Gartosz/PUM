package com.example.studenthardlife.data

object TasksData {
    private lateinit var listsElements: MutableList<ListElement>

    fun getLists(): List<ListElement>
    {
        return listsElements.toList()
    }

    fun importLists(list: List<ListElement>)
    {
        listsElements = list.toMutableList()
    }

    fun addList(title: String)
    {
        val newList = ListElement(title)
        listsElements.add(newList)
    }
}