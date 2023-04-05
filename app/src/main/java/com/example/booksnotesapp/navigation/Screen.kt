package com.example.booksnotesapp.navigation

import com.example.booksnotesapp.utils.Constants.BOOK_SCREEN
import com.example.booksnotesapp.utils.Constants.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOK_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}
