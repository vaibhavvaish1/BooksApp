package com.example.bookshelfapp.domain.repository
import com.example.bookshelfapp.modals.BookDetail
import com.example.bookshelfapp.modals.BookList

interface BooksRepository {
    suspend fun getPhotos (category : String) : BookList

    suspend fun getBookById(volumeId :  String) : BookDetail
}
