package com.example.booksnotesapp.presentation.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.utils.Constants.BOOK_SCREEN
import com.example.booksnotesapp.utils.Constants.DELETE_BOOK
import com.example.booksnotesapp.viewmodel.BookViewModel

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
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(padding)) {
        items(
            items = books
        ) { book ->
            BookCard(
                book = book,
                deleteBook = { deleteBook(book) },
                navigateToUpdateScreen = navigateToUpdateScreen
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BookCard(
    book: Book,
    deleteBook: () -> Unit,
    navigateToUpdateScreen: (Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateScreen(book.id)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                TextTitle(bookTitle = book.title)
                TextAuthor(bookAuthor = book.author)
            }
            Spacer(modifier = Modifier.weight(1f))
            DeleteIcon(deleteBook = deleteBook)
        }
    }
}

@Composable
fun TextTitle(
    bookTitle: String
) {
    Text(
        text = bookTitle,
        color = Color.DarkGray,
        fontSize = 25.sp
    )
}

@Composable
fun TextAuthor(
    bookAuthor: String
) {
    Text(
        text = "by $bookAuthor",
        color = Color.DarkGray,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun DeleteIcon(
    deleteBook: () -> Unit
) {
    IconButton(
        onClick = deleteBook
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_BOOK,
        )
    }
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

@Composable
fun BooksTopBar() {
    TopAppBar(
        title = {
            Text(text = BOOK_SCREEN)
        }
    )
}
