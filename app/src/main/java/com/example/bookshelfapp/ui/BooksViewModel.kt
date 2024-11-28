package com.example.bookshelfapp.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelfapp.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


sealed interface BooksListUiState {
    data class Success(val photos: List<String>) : BooksListUiState
    object Error : BooksListUiState
    object Loading : BooksListUiState
}

@HiltViewModel
class BooksViewModel @Inject constructor(private val booksPhotoRepository: BooksRepository) : ViewModel() {
    var booksUiState: BooksListUiState by mutableStateOf(BooksListUiState.Loading)
        private set

    var category by mutableStateOf("")
        private set

    fun updateCategory(newCategory: String) {
        category = newCategory
        Log.i("TAG", "updateCategory: " + category)
        getBookListData()
    }

    private fun getBookListData() {
        viewModelScope.launch {
            booksUiState = BooksListUiState.Loading
            booksUiState = try {
                val booksPhotoRepository = booksPhotoRepository
                val listResult = booksPhotoRepository.getPhotos(category)
                val imageUrls = listResult.items.map { bookItem ->
                    // Fetch the image for each book asynchronously
                    async {
                        // Step 3: Call getBookById for each volumeId
                        val bookDetail = booksPhotoRepository.getBookById(bookItem.id)
                        // Return the image URL if available
                        bookDetail.volumeInfo.imageLinks?.thumbnail
                    }
                }

                // Step 4: Await all the image URL requests
                val resultImageUrls = imageUrls.awaitAll().filterNotNull()


                BooksListUiState.Success(resultImageUrls)
            } catch (e: IOException) {
                BooksListUiState.Error
            } catch (e: HttpException) {
                BooksListUiState.Error
            }
        }
    }
}