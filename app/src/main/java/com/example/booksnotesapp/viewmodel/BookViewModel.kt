package com.example.booksnotesapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
    ): ViewModel() {

    val books: Flow<Book> = bookRepository.getBooksFromRoom()
    var book = Book(0,"","")
    var showDialog by mutableStateOf(false)

    fun getBooksFromId(id: Int) {
        viewModelScope.launch {
            book = bookRepository.getBookFromRoom(id)
        }
    }

    fun addBook(book: Book) {
        viewModelScope.launch {
            bookRepository.addBookToRoom(book)
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            bookRepository.deleteBookInRoom(book)
        }
    }

    fun updateBook(book: Book) {
        viewModelScope.launch {
            bookRepository.updateBookInRoom(book)
        }
    }

    fun updateTitle(title: String) {
        book = book.copy(title = title)
    }

    fun updateAuthor(author: String) {
        book = book.copy(author = author)
    }

    fun closeDialog() {
        showDialog = false
    }

    fun openDialog() {
        showDialog = true
    }
}
