package com.example.myapplication.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.ui.components.ActionButton

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun ImageDetailScreen(imageUrl: String,navController: NavController) {
    val otherImages = listOf(
        "https://picsum.photos/800/1200",
        "https://picsum.photos/900/1200",
        "https://picsum.photos/1000/1200",
        "https://picsum.photos/800/1000",
        "https://picsum.photos/900/1100",
        "https://picsum.photos/1200/800",
        "https://picsum.photos/1200/900",
        "https://picsum.photos/1080/1920",
        "https://picsum.photos/1200/1600",
        "https://picsum.photos/1000/1500",
        "https://picsum.photos/900/1400",
        "https://picsum.photos/1200/1200",
        "https://picsum.photos/1400/900",
        "https://picsum.photos/1600/1200",
        "https://picsum.photos/1500/1000",
        "https://picsum.photos/1920/1080",
        "https://picsum.photos/1600/1600",
        "https://picsum.photos/1800/1200",
        "https://picsum.photos/1200/1800",
        "https://picsum.photos/1400/1400"
    )
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(12.dp))
            .fillMaxSize()


    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.FavoriteBorder, null)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(Icons.Default.MailOutline, null)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(Icons.Default.Share, null)
                    Spacer(modifier = Modifier.width(12.dp))
                    Icon(Icons.Default.MoreVert, null)

                    Spacer(modifier = Modifier.weight(1f)) // ⬅ pushes button right

                    ActionButton(
                        text = "Сохранить",
                        onClick = {  },
                        modifier = Modifier
                            .width(120.dp)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier.padding(start = 12.dp),
                    verticalAlignment = Alignment.CenterVertically // ⬅ выравнивание по центру
                ) {
                    AsyncImage(
                        model = "",
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color.Black),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Mahnur",
                        modifier = Modifier.padding(start = 5.dp), // padding только слева
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }

            item {
                Column {
                    Text(
                        text = "Title of post",
                        modifier = Modifier.padding(14.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "Long description goes here...\nMore text to enable scrolling.",
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

            }
            item {
                Column {
                    Text(
                        text = "Другие интересные пины",
                        modifier = Modifier.padding(14.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }


            item {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    verticalItemSpacing = 8.dp,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .height(screenHeight * 2) // grid не просит бесконечную высоту
                ) {
                    items(otherImages) { url ->
                        PinterestImage(url = url, navController = navController)
                    }
                }
            }


        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .padding(12.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.LightGray)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    navController.popBackStack()
                }
                .align(Alignment.TopStart)
        )
    }
}
