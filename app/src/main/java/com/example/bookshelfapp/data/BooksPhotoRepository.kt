package com.example.bookshelfapp.data

import com.example.bookshelfapp.modals.BookDetail
import com.example.bookshelfapp.modals.BookList
import com.example.bookshelfapp.network.BooksApiService

interface BooksPhotoRepository {
    suspend fun getPhotos (category : String) : BookList

    suspend fun getBookById(volumeId :  String) : BookDetail
}

class NetworkBooksPhotoRepository( private val marsApiService: BooksApiService) : BooksPhotoRepository {
    override suspend fun getPhotos(category: String): BookList {
        return marsApiService.getPhotos(category)
    }

    override suspend fun getBookById(volumeId :  String): BookDetail {
        return marsApiService.getBookById(volumeId)
    }
}