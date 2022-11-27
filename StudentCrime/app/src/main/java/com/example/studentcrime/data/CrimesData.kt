package com.example.studentcrime.data

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object CrimesData {
    private val title = listOf("Kradzież", "Plagiat")
    private val description = listOf("Student ukradł układ ArduinoNano.", "Pracę zaliczeniową skopiował w większości o kolegi " +
            "i twierdził, że to on jest autorem.")
    private val createDatetime:List<LocalDateTime> = createDatesList()
    private val studentIndex = listOf("536", "089")
    private val solvedStatus = listOf(true, false)

    private fun createDatesList(): List<LocalDateTime> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val datesList = listOf("2022-10-16 14:38", "2022-11-02 08:23")
        val parsedDates = mutableListOf<LocalDateTime>()
        for (date in datesList)
            parsedDates.add(LocalDateTime.parse(date, formatter))
        return parsedDates.toList()
    }

    fun getDetailedCrime(index: Int): Map<String, Any> {
        return mapOf<String, Any>(
            "Title" to title[index], "Description" to description[index],
            "Datetime" to createDatetime[index], "Student Index" to studentIndex[index],
            "Status" to solvedStatus[index]
        )
    }

    fun getCrimes(): Pair<List<LocalDateTime>, List<Boolean>>
    {
        return Pair(createDatetime, solvedStatus)
    }

}