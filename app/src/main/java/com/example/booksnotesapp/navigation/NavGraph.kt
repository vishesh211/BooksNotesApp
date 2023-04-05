package com.example.booksnotesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.booksnotesapp.utils.Constants.BOOK_ID

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.BooksScreen.route
    ) {
        composable(route = Screen.BooksScreen.route) {

        }

        composable(route = "${Screen.UpdateBookScreen.route}/{$BOOK_ID}", arguments = listOf(
            navArgument(BOOK_ID) {
                type = NavType.IntType
            }
        )) {

        }
    }
}