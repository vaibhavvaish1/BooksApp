import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookshelfapp.R
import com.example.bookshelfapp.modals.Category
import com.example.bookshelfapp.ui.theme.BookShelfAppTheme


@Composable
fun CategoryCard(
    category: Category,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryName = stringResource(id = category.textResId) // Resolve string resource here
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick(categoryName) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = category.colorResId) // Use colorResource
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = stringResource(id = category.textResId),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                color = colorResource(R.color.white)
            )
        }
    }
}

@Composable
fun CategoryGridScreen(
    photos: List<Category>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp),
    ) {
        items(items = photos, key = { photo -> photo.textResId }) { photo ->
            CategoryCard(
                photo, modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f),
                onClick = { clickedText ->
                    onClick(clickedText)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    BookShelfAppTheme {
        val mockData = List(10) {
            Category(R.string.cat_fiction, R.color.cat_fiction)
        }
        CategoryGridScreen(mockData,onClick = {})
    }
}

