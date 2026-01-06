package com.example.myapplication.ui.components

import com.example.myapplication.R

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = R.drawable.home,
            route = "home"
        ),
        BottomNavItem(
            label = "Search",
            icon = R.drawable.search,
            route = "search"
        ),
        BottomNavItem(
            label = "Add",
            icon = R.drawable.add,
            route = "add"
        ) ,
        BottomNavItem(
            label = "Messages",
            icon = R.drawable.messages,
            route = "message"
        ),
        BottomNavItem(
            label = "Profile",
            icon = R.drawable.profile,
            route = "profile"
        )
    )
}