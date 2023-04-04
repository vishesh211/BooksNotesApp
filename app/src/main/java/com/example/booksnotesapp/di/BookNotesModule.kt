package com.example.booksnotesapp.di

import android.content.Context
import androidx.room.Room
import com.example.booksnotesapp.db.BookDb
import com.example.booksnotesapp.utils.Constants.BOOK_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BookNotesModule {

    @Provides
    @Singleton
    fun provideBookDb(@ApplicationContext context: Context): BookDb {
        return Room.databaseBuilder(
            context,
            BookDb::class.java,
            BOOK_TABLE
        ).build()
    }

    @Provides
    @Singleton
    fun provideBookDao(database: BookDb) = database.bookDao
}