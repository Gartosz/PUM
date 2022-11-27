package com.example.studentcrime.data

import java.time.LocalDateTime

object CrimesData {
    private val title = listOf("Kradzież")
    private val description = listOf("Student ukradł układ ArduinoNano.")
    private val create_datetime = listOf<LocalDateTime>(LocalDateTime.parse("2022-10-16 14:38"))
    private val student_index = listOf<Int>(536)
    private val solved_status = listOf<Boolean>(false)
    val crime_count = title.size

    fun getCrime(index: Int): Map<String, Any> {
        return mapOf<String, Any>(
            "Title" to title[index], "Description" to description[index],
            "Datetime" to create_datetime[index],"Student Index" to student_index[index],
            "Status" to solved_status[index]
        )
    }
}