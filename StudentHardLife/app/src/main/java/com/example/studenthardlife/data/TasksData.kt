package com.example.studenthardlife.data

object TasksData {
    private lateinit var listsElements: List<ListElement>

    fun getLists(): List<ListElement>
    {
        return listsElements
    }

    fun importLists(list: List<ListElement>)
    {
        listsElements = list
    }
}