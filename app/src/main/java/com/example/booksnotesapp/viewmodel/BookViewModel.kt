package com.example.booksnotesapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.booksnotesapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
    ): ViewModel() {

}