package com.example.getwell.screens.stressanalysis

import com.google.firebase.Timestamp

data class StressAIObj(
    val level: Int = 0,
    val timestamp: Timestamp = Timestamp.now()
)
