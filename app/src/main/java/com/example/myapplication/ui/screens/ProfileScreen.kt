package com.example.myapplication.ui.screens

import ProfileTopBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            ProfileTopBar(
                onShareClick = { /* TODO: share logic */ },
                onSettingsClick = { /* TODO: settings logic */ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier

                .padding(innerPadding)
        ) {
            // Контент экрана
        }
    }
}
