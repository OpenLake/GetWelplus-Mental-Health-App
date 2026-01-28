package com.example.getwell.data

import com.example.getwell.core.ui.R as UiR

data class NavItem (
    val title: String,
    val route: String,
    val icon: Int
)

val navItemList =  listOf(
    NavItem(
        title ="Home",
        route = Screen.HomeScreen.route,
        icon =  UiR.drawable.home_icon
    ),
    NavItem(
        title ="Chatroom",
        route = Screen.ChatroomScreen.route,
        icon = UiR.drawable.chatnavicon
    ),
    NavItem(
        title ="Relax",
        route = Screen.RelaxScreen.route,
        icon = UiR.drawable.game_icon__1_
    ),
    NavItem(
        title ="Resources",
        route = Screen.EducationScreen.route,
        icon = UiR.drawable.resource_icon
    ),
    NavItem(
        title ="ChatBot",
        route = Screen.ChatBot.route,
        icon = UiR.drawable.chatbot
    ),
    NavItem(
        title ="Profile",
        route = Screen.ProfileScreen.route,
        icon = UiR.drawable.profile_icon
    )

)
