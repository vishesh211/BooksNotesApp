package com.example.booksnotesapp.presentation.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.utils.Constants.BOOK_SCREEN
import com.example.booksnotesapp.viewmodel.BookViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun BooksScreen(
    viewModel: BookViewModel = hiltViewModel(),
    navigateToUpdateScreen: (Int) -> Unit
) {
    val books by viewModel.books.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            BooksTopBar()
        },
        floatingActionButton = {
            AddBookFloatingActionButton(openDialog = {
                viewModel.openDialog()
            })
        }
    ) {
        BooksContent(
            padding = it,
            books = books,
            deleteBook = { book ->
                viewModel.deleteBook(book)
            },
            navigateToUpdateScreen = navigateToUpdateScreen
        )
    }
}

@Composable
fun BooksContent(
    padding: PaddingValues,
    books: List<Book>,
    deleteBook: (Book) -> Unit,
    navigateToUpdateScreen: (Int) -> Unit
) {
    TODO("Not yet implemented")
}

@Composable
fun AddBookFloatingActionButton(openDialog: () -> Unit) {
    FloatingActionButton(
        onClick = openDialog,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Image(
            imageVector = Icons.Default.Add,
            contentDescription = "Add"
        )
    }
}

@Preview
@Composable
fun BooksTopBar() {
    TopAppBar(
        title = {
            Text(text = BOOK_SCREEN)
        }
    )
}
