package com.ex.volunteerfinder.view

import com.ex.volunteerfinder.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
    object Events : NavigationItem("events", R.drawable.ic_social, "Events")
    object Map : NavigationItem("map", R.drawable.ic_location, "Map")
    object Inbox : NavigationItem("inbox", R.drawable.ic_message, "Inbox")
    object Conversation : NavigationItem("conversation", R.drawable.ic_message, "Conversation")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
