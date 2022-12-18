package com.example.studenthardlife.data

object TasksData {
    private var titles = listOf<String>("Lista 1", "Lista 2")
    private var contents = listOf<String>("Zadanie 1", "Zadanie 1")
    private var listsElements = listOf<ListElement>(ListElement(titles[0]), ListElement(titles[1]))

    fun getLists(): List<ListElement>
    {
        return listsElements
    }

    fun importLists(list: List<ListElement>)
    {
        listsElements = list
    }
}