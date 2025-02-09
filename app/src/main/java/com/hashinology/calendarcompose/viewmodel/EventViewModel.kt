// File: viewmodel/EventViewModel.kt
package com.hashinology.calendarcompose.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hashinology.calendarcompose.data.Event
import com.hashinology.calendarcompose.data.EventRepository
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
class EventViewModel : ViewModel() {

    // A simple state for events; in a real app, consider using StateFlow or LiveData
    var events by mutableStateOf(EventRepository.getAllEvents())
        private set

    var selectedDate by mutableStateOf(LocalDate.now())
        set
    var searchQuery by mutableStateOf("")
        private set

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    /*fun setSelectedDate(date: LocalDate) {
        selectedDate = date
    }*/

    // This function compiles event details and launches a share intent.
    fun shareCalendar(context: Context) {
        // For demo purposes, we simply share a text summary of all events.
        val calendarText = events.joinToString(separator = "\n") { event ->
            "${event.title}: ${event.startTime} - ${event.endTime} (${event.category})"
        }

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, calendarText)
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share Calendar via"))
    }
}
