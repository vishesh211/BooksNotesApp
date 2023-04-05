package com.example.booksnotesapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.booksnotesapp.navigation.NavGraph
import com.example.booksnotesapp.ui.theme.BooksNotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksNotesAppTheme {
                NavGraph(navController = rememberNavController())
            }
        }
    }
}
