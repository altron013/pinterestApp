package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController



@Composable
fun HomeScreen(navController:NavController) {
    val images = listOf(
        "https://picsum.photos/300/500",
        "https://picsum.photos/400/300",
        "https://picsum.photos/350/450",
        "https://picsum.photos/200/400",
        "https://picsum.photos/450/300",
        "https://picsum.photos/300/400",
        "https://picsum.photos/400/500",
        "https://picsum.photos/500/300",
        "https://picsum.photos/300/600",
        "https://picsum.photos/350/500",
        "https://picsum.photos/450/400",
        "https://picsum.photos/400/450",
        "https://picsum.photos/500/350",
        "https://picsum.photos/300/300",
        "https://picsum.photos/350/350",
        "https://picsum.photos/400/400",
        "https://picsum.photos/450/450",
        "https://picsum.photos/500/500",
        "https://picsum.photos/300/350",
        "https://picsum.photos/350/300"
    )

    fun String.toRoute(): String =
        this.lowercase()
            .replace(" ", "_")
            .replace(Regex("[^a-z0-9_]"), "")

    data class ChipItem(
        val title: String,
        val route: String = title.toRoute()
    )


    val chipCategoryList = listOf(
        ChipItem("Дерзкий макияж"),
        ChipItem("Insta"),
        ChipItem("Мило"),
        ChipItem("Позы"),
        ChipItem("Маст"),
        ChipItem("Фильм"),
        ChipItem("Moto"),
        ChipItem("Прически")
    )
    Column (modifier = Modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier.padding(start = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(chipCategoryList) { chip ->
                SuggestionChip(
                    border = null,
                    onClick = {
                        navController.navigate("category/${chip.title}")                    },
                    label = {
                        Text(chip.title)
                    },

                )
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize() // обязательно
        ) {
            items(images) { url ->
                PinterestImage(url = url, navController = navController)
            }
        }
    }
}

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search",
            tint = Color(0xFF0F9D58)
        )
        Text(text = "Search", color = Color.Black)
    }
}




