// File: data/EventRepository.kt
package com.hashinology.calendarcompose.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

object EventRepository {
    // Sample events
    @RequiresApi(Build.VERSION_CODES.O)
    private val events = mutableListOf(
        Event(
            id = 1L,
            title = "Team Meeting",
            description = "Discuss project updates",
            startTime = LocalDateTime.now().withHour(10).withMinute(0),
            endTime = LocalDateTime.now().withHour(11).withMinute(0),
            category = EventCategory.WORK,
            recurrence = Recurrence.WEEKLY
        ),
        Event(
            id = 2L,
            title = "Gym",
            description = "Workout session",
            startTime = LocalDateTime.now().withHour(18).withMinute(30),
            endTime = LocalDateTime.now().withHour(19).withMinute(30),
            category = EventCategory.PERSONAL,
            recurrence = Recurrence.DAILY
        ),
        Event(
            id = 3L,
            title = "Birthday Party",
            description = "Celebrate with friends",
            startTime = LocalDateTime.now().plusDays(2).withHour(20).withMinute(0),
            endTime = LocalDateTime.now().plusDays(2).withHour(23).withMinute(0),
            category = EventCategory.OTHER
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllEvents(): List<Event> = events

    @RequiresApi(Build.VERSION_CODES.O)
    fun addEvent(event: Event) {
        events.add(event)
    }
}
