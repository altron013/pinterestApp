package com.example.myapplication.ui.components

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val label:String,
    @DrawableRes val icon: Int,
    val route:String
)