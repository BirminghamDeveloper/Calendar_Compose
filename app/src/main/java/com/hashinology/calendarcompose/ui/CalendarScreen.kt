// File: ui/CalendarScreen.kt
package com.hashinology.calendarcompose.ui

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel // <-- Correct import
import com.hashinology.calendarcompose.ui.components.CalendarGrid
import com.hashinology.calendarcompose.ui.components.EventList
import com.hashinology.calendarcompose.ui.components.SearchBar
import com.hashinology.calendarcompose.viewmodel.EventViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(eventViewModel: EventViewModel = viewModel()) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calendar Compose") },
                actions = {
                    IconButton(onClick = { eventViewModel.shareCalendar(context) }) {
                        Icon(Icons.Filled.Share, contentDescription = "Share Calendar")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Placeholder: In a real app, navigate to the Add Event screen.
                Toast.makeText(context, "Add Event Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add Event")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            SearchBar(
                query = eventViewModel.searchQuery,
                onQueryChanged = eventViewModel::updateSearchQuery
            )
            CalendarGrid(
                selectedDate = eventViewModel.selectedDate,
                onDateSelected = {
                    eventViewModel.selectedDate = it
                }
            )
            // Filter events based on selected date and search query.
            val filteredEvents = eventViewModel.events.filter { event ->
                event.startTime.toLocalDate() == eventViewModel.selectedDate &&
                        event.title.contains(eventViewModel.searchQuery, ignoreCase = true)
            }
            EventList(events = filteredEvents)
        }
    }
}

@Composable
@Preview
fun CalendarScreenPreview(modifier: Modifier = Modifier) {
    CalendarScreen()
}