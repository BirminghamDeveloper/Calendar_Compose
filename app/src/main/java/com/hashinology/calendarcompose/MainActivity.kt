// File: MainActivity.kt
package com.hashinology.calendarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hashinology.calendarcompose.ui.CalendarScreen
import com.hashinology.calendarcompose.ui.theme.CalendarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarComposeTheme {
                CalendarScreen()
            }
        }
    }
}
