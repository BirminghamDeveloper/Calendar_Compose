// File: ui/components/EventList.kt
package com.hashinology.calendarcompose.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.hashinology.calendarcompose.data.Event

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventList(events: List<Event>) {
    LazyColumn {
        items(events.size) { index ->
            EventItem(event = events[index])
        }
    }
}
