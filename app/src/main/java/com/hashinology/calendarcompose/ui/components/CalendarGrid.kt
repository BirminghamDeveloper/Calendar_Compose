// File: ui/components/CalendarGrid.kt
package com.hashinology.calendarcompose.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarGrid(
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    // For simplicity, we display the current week (7 days).
    val startOfWeek = selectedDate.minusDays(selectedDate.dayOfWeek.value.toLong() - 1)
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.padding(8.dp)
    ) {
        (0L until 7L).forEach { offset ->
            val date = startOfWeek.plusDays(offset)
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { onDateSelected(date) }
            ) {
                Text(
                    text = date.dayOfMonth.toString(),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
