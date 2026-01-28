package com.example.getwell.data

import com.google.firebase.Timestamp

data class Mood(
    val id: Int = 0,  // Default value
    val timestamp: Timestamp = Timestamp.now()  // Default value
)
