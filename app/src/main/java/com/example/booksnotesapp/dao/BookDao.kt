package com.example.booksnotesapp.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.example.booksnotesapp.models.Book
import com.example.booksnotesapp.utils.Constants.BOOK_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM $BOOK_TABLE ORDER BY id ASC")
    fun getBooks(): Flow<Book>

    @Query("SELECT * FROM $BOOK_TABLE WHERE id = :id")
    suspend fun getBook(id: Int): Book

    @Insert(onConflict = IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}