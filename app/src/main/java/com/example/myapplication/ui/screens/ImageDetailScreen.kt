package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage

@Composable
fun ImageDetailScreen(imageUrl: String) {
    Box(
        modifier = Modifier
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            //modifier = Modifier.fillMaxSize()
        )
    }
}
