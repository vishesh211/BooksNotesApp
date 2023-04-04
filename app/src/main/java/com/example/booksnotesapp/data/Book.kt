package com.example.booksnotesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.booksnotesapp.utils.Constants.BOOK_TABLE

@Entity(tableName = BOOK_TABLE)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String
)
