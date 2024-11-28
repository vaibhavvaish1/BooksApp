package com.example.bookshelfapp.data.repository

import android.app.Application
import com.example.bookshelfapp.domain.repository.BooksRepository
import com.example.bookshelfapp.modals.BookDetail
import com.example.bookshelfapp.modals.BookList
import com.example.bookshelfapp.network.BooksApiService
import javax.inject.Inject

class BooksRepositoryImpl @Inject constructor( private val marsApiService: BooksApiService, private val appContext : Application) :
    BooksRepository {
    override suspend fun getPhotos(category: String): BookList {
        return marsApiService.getPhotos(category)
    }

    override suspend fun getBookById(volumeId :  String): BookDetail {
        return marsApiService.getBookById(volumeId)
    }
}