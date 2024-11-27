package com.example.bookshelfapp.data

import com.example.bookshelfapp.network.BooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksPhotoRepository : BooksPhotoRepository
}

class DefaultAppContainer : AppContainer {

    private  val BASE_URL = "https://www.googleapis.com/books/v1/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }

    override val booksPhotoRepository: BooksPhotoRepository by lazy {
        NetworkBooksPhotoRepository(retrofitService)
    }


}