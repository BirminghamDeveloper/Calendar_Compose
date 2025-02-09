// File: data/Event.kt
package com.hashinology.calendarcompose.data

import java.time.LocalDateTime

enum class Recurrence {
    NONE, DAILY, WEEKLY, MONTHLY
}

enum class EventCategory {
    PERSONAL, WORK, HOLIDAY, OTHER
}

data class Event(
    val id: Long,
    val title: String,
    val description: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val category: EventCategory = EventCategory.OTHER,
    val recurrence: Recurrence = Recurrence.NONE
)
