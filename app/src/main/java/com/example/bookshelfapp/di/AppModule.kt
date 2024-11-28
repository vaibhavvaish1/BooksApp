package com.example.bookshelfapp.di

import android.app.Application
import com.example.bookshelfapp.data.repository.BooksRepositoryImpl
import com.example.bookshelfapp.domain.repository.BooksRepository
import com.example.bookshelfapp.network.BooksApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMyApi() : BooksApiService{
       return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.googleapis.com/books/v1/")
            .build().create(BooksApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideBookRepository(api : BooksApiService, app: Application) : BooksRepository{
        return BooksRepositoryImpl(api, app)
    }
}