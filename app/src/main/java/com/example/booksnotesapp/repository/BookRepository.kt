package com.example.booksnotesapp.repository

import com.example.booksnotesapp.dao.BookDao
import com.example.booksnotesapp.models.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(
    private val bookDao: BookDao
) {
    fun getBooksFromRoom() = bookDao.getBooks()

    suspend fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    suspend fun addBookToRoom(book: Book) = bookDao.addBook(book)

    suspend fun updateBookInRoom(book: Book) = bookDao.updateBook(book)

    suspend fun deleteBookInRoom(book: Book) = bookDao.deleteBook(book)
}