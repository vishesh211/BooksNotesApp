package com.example.booksnotesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.booksnotesapp.dao.BookDao
import com.example.booksnotesapp.models.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb: RoomDatabase() {
    abstract val bookDao: BookDao
}