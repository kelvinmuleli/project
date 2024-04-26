@file:OptIn(ExperimentalMaterial3Api::class)

package net.ezra.ui.home

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.lightColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_BOOKMARKED_ROUTES
import net.ezra.navigation.ROUTE_ROUTES_LIST

@Composable
fun HomeScreen(navController: Nothing?) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_ROUTES_LIST
    ) {
        composable(ROUTE_ROUTES_LIST) {
            RoutesList(navController)
        }
        composable(ROUTE_BOOKMARKED_ROUTES) {
            BookmarkedRoutes()
        }
        // Add more composable destinations for other screens
    }
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RoutesList(navController: NavController) {
    // Fetch routes data from ViewModel or repository

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Routes") },
                actions = {
                    IconButton(onClick = { /* Navigate to BookmarkedRoutes screen */ }) {
                        Icon(Icons.Filled.Bookmark, contentDescription = "Bookmarks")
                    }
                }
            )
        }
    ) {
        // Display list of routes
    }
}

fun Icon(bookmark: Any, contentDescription: String) {

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookmarkedRoutes() {
    // Fetch bookmarked routes data from ViewModel or repository

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bookmarked Routes") },
                navigationIcon = {
                    IconButton(onClick = { /* Navigate back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        /* Display list of bookmarked routes */
    }
}



@Composable
fun TransportAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        //typography = Typography,
        //shapes = Shapes,
        content = content
    )
}


private val Icons.Filled.Bookmark: Any
    get() {
        TODO("Not yet implemented")
    }
val Typography = Typography(
    // Define typography styles
)

private operator fun Typography.invoke(): Any {
    TODO("Not yet implemented")

}

val LightThemeColors = lightColors(
    // Define light theme colors
)

val DarkThemeColors = darkColors(
    // Define dark theme colors
)







@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    TransportAppTheme {
        val navController = null
        HomeScreen(navController)
    }
}

