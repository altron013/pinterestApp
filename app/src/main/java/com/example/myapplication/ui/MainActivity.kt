package com.example.myapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.components.Constants
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.ImageDetailScreen
import com.example.myapplication.ui.screens.ProfileScreen
import com.example.myapplication.ui.screens.SearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                PermissionRequester()
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->
                            NavHostContainer(navController = navController, padding = padding)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),

        builder = {
            composable("home") {
                HomeScreen(navController)
            }
            composable("search") {
                SearchScreen()
            }
            composable("profile") {
                ProfileScreen()
            }
            composable("add") {
                ProfileScreen()
            }
            composable("message") {
                ProfileScreen()
            }
            composable("category/{name}") { backStack ->
                val name = backStack.arguments?.getString("name")
                Text("Категория: $name")
            }
            composable(
                "details/{imageUrl}",
                arguments = listOf(navArgument("imageUrl") {
                    type = NavType.StringType
                })
            ) { backStackEntry ->
                val url = backStackEntry.arguments?.getString("imageUrl")
                url?.let { ImageDetailScreen(it) }
            }

        })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar(
         modifier = Modifier.shadow(10.dp),
        // set background color
        containerColor = Color(0xFFFFFFFF)) {
        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {

                    Icon( painter = painterResource(id = navItem.icon),
                         contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = true,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black, // Icon color when selected
                    unselectedIconColor = Color.Gray, // Icon color when not selected
                    selectedTextColor = Color.Black, // Label color when selected
                    indicatorColor = Color.Transparent // Highlight color for selected item
                )
            )
        }
    }
}