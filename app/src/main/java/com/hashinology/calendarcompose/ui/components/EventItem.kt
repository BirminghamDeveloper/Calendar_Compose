// File: ui/components/EventItem.kt
package com.hashinology.calendarcompose.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hashinology.calendarcompose.data.Event
import com.hashinology.calendarcompose.data.EventCategory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventItem(event: Event) {
    // Choose a color based on the event category.
    val backgroundColor: Color = when (event.category) {
        EventCategory.PERSONAL -> Color(0xFFD1E8E2)
        EventCategory.WORK -> Color(0xFFFFE0B2)
        EventCategory.HOLIDAY -> Color(0xFFFFCDD2)
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.titleMedium)
            Text(text = event.description, style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "${event.startTime.toLocalTime()} - ${event.endTime.toLocalTime()}",
                style = MaterialTheme.typography.bodySmall
            )
            if (event.recurrence != com.hashinology.calendarcompose.data.Recurrence.NONE) {
                Text(text = "Repeats: ${event.recurrence}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
