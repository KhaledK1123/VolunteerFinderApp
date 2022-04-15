package com.ex.volunteerfinder.view

import com.ex.volunteerfinder.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Events : NavigationItem("events", R.drawable.ic_social, "Events")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}
