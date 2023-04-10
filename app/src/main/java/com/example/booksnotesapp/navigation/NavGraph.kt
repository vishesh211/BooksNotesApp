package com.example.booksnotesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.booksnotesapp.presentation.books.BooksScreen
import com.example.booksnotesapp.presentation.update_book.UpdateBookScreen
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
            BooksScreen(
                navigateToUpdateScreen = { bookId ->
                    navController.navigate(
                        route = "${Screen.UpdateBookScreen.route}/${bookId}"
                    )
                }
            )
        }

        composable(route = "${Screen.UpdateBookScreen.route}/{$BOOK_ID}", arguments = listOf(
            navArgument(BOOK_ID) {
                type = NavType.IntType
            }
        )) {
            val bookId = it.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(bookId = bookId) {
                navController.popBackStack()
            }
        }
    }
}