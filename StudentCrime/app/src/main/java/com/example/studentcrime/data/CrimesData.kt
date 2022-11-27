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

    fun getCrime(index: Int): Map<String, Any> {
        return mapOf<String, Any>(
            "Title" to title[index], "Description" to description[index],
            "Datetime" to create_datetime[index],"Student Index" to student_index[index],
            "Status" to solved_status[index]
        )
    }
}