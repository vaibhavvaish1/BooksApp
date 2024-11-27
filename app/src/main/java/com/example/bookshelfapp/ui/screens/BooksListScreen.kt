package com.example.bookshelfapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelfapp.R
import com.example.bookshelfapp.modals.BookDetail
import com.example.bookshelfapp.ui.BooksListUiState
import com.example.bookshelfapp.ui.BooksViewModel
import com.example.bookshelfapp.ui.theme.BookShelfAppTheme


//@Composable
//fun BooksListScreen(
//    bookListUiState: BooksListUiState,
//    modifier: Modifier = Modifier,
//    retryAction: () -> Unit,
//    contentPadding: PaddingValues = PaddingValues(0.dp),
//) {
//    when (bookListUiState) {
//        is BooksListUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is BooksListUiState.Success -> PhotosGridScreen(bookListUiState.photos, modifier.fillMaxSize())
//        is BooksListUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
//    }
//}

@Composable
fun HomeScreen(
    booksViewModel: BooksViewModel,
    bookListUiState: BooksListUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (bookListUiState) {
        is BooksListUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BooksListUiState.Success -> PhotosGridScreen(
            bookListUiState.photos
            , modifier = modifier.fillMaxWidth()
        )
        is BooksListUiState.Error -> ErrorScreen({}, modifier = modifier.fillMaxSize())
    }
}


/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
fun BookPhotoCard(photo: String, modifier: Modifier = Modifier) {
    Log.i("TAG", "BookPhotoCard: "+photo)
    fun convertHttpToHttps(url: String): String {
        return if (url.startsWith("http://")) {
            "https://" + url.substring(7)  // Remove "http://" and add "https://"
        } else {
            url  // Return the original URL if it doesn't start with "http://"
        }
    }
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(convertHttpToHttps(photo))
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.mars_photo),
            modifier = Modifier.fillMaxWidth().fillMaxHeight().aspectRatio(2f/3f),
            contentScale = ContentScale.Crop
        )
    }
}

/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}

@Composable
fun PhotosGridScreen(
    photos: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding,
    ) {
        items(items = photos) {
                photo -> BookPhotoCard(photo,  modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(2f / 3f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    BookShelfAppTheme {
        LoadingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    BookShelfAppTheme {
        ErrorScreen({})
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun PhotosGridScreenPreview() {
//    BookShelfAppTheme {
//        val mockData = List(10) { MarsPhoto("$it", "") }
//        PhotosGridScreen(mockData)
//    }
//}
