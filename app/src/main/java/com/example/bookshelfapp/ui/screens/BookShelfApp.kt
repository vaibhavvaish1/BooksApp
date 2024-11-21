package com.example.bookshelfapp.ui.screens

import CategoryGridScreen
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookshelfapp.R
import com.example.bookshelfapp.data.CategoryDataSource
import javax.sql.DataSource


enum class BookShelfScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    BooksList(title = R.string.list_of_books),
    BookSummary(title = R.string.book_summary),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfAppBar(
    currentScreen: BookShelfScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun BookShelfApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = BookShelfScreen.valueOf(
        backStackEntry?.destination?.route ?: BookShelfScreen.Start.name
    )

    Scaffold(
        topBar = {
            BookShelfAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = BookShelfScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = BookShelfScreen.Start.name) {
                CategoryGridScreen(
                    photos = CategoryDataSource.categories,
                    modifier = Modifier
                        .fillMaxSize(),
                    onClick = { queryText -> navController.navigate("${BookShelfScreen.BooksList.name}/$queryText")}
                )
            }
        }
    }
}