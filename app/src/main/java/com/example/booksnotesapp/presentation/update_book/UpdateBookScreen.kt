package com.example.booksnotesapp.presentation.update_book

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.utils.Constants.UPDATE_BOOK_SCREEN
import com.example.booksnotesapp.viewmodel.BookViewModel

@Composable
fun UpdateBookScreen(
    viewModel: BookViewModel = hiltViewModel(),
    bookId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBooksFromId(bookId)
    }
    
    Scaffold(
        topBar = { UpdateBookTopBar(navigateBack) }
    ) {
        UpdateBookContent(
            padding = it,
            book = viewModel.book,
            updateTitle = { title ->
                viewModel.updateTitle(title)
            },
            updateAuthor = { author ->
                viewModel.updateAuthor(author)
            },
            updateBook = { book ->
                viewModel.updateBook(book)
            },
            navigateBack = navigateBack
        )
    }
}

@Composable
fun UpdateBookContent(
    padding: PaddingValues,
    book: Book,
    updateTitle: (title: String) -> Unit,
    updateAuthor: (author:  String) -> Unit,
    updateBook: (book: Book) -> Unit,
    navigateBack: () -> Unit
) {

}

@Composable
fun UpdateBookTopBar(navigateBack: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = UPDATE_BOOK_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
            }
        }
    )
}
