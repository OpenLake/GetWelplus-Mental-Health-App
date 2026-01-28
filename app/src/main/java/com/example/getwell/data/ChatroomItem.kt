package com.example.getwell.data

import androidx.annotation.DrawableRes
import com.example.getwell.core.ui.R as UiR

data class ChatroomItem(
    val id: Long = 0L,
    val title: String,
    val description: String,
    @DrawableRes val icon : Int = UiR.drawable._icon__google_
)
