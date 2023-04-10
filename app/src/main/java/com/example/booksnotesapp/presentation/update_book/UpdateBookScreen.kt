package com.example.booksnotesapp.presentation.update_book

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.utils.Constants.AUTHOR
import com.example.booksnotesapp.utils.Constants.BOOK_TITLE
import com.example.booksnotesapp.utils.Constants.UPDATE
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = book.title, 
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(text = BOOK_TITLE)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = book.author,
            onValueChange = { author ->
                updateAuthor(author)
            },
            placeholder = {
                Text(text = AUTHOR)
            }
        )
        Button(onClick = {
            updateBook(book)
            navigateBack()
        }) {
            Text(
                text = UPDATE
            )
        }
    }
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
