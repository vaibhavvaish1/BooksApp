package com.example.bookshelfapp.network

import com.example.bookshelfapp.modals.BookDetail
import com.example.bookshelfapp.modals.BookList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BooksApiService {
    @GET("volumes")
    suspend fun getPhotos(
        @Query("q") query: String, // dynamic part of the path
    ): BookList

    @GET("volumes/{volumeId}")
    suspend fun getBookById(@Path("volumeId") volumeId: String): BookDetail
}

