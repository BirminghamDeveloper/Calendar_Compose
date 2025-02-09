// File: ui/components/SearchBar.kt
package com.hashinology.calendarcompose.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = modifier,
        label = { Text("Search events") },
        singleLine = true
    )
}
