package com.example.bookshelfapp.data

import com.example.bookshelfapp.R
import com.example.bookshelfapp.modals.Category

object CategoryDataSource {

    val categories = listOf(
        Category(R.string.cat_fiction, R.color.cat_fiction),
        Category(R.string.cat_non_fiction, R.color.cat_non_fiction),
        Category(R.string.cat_mystery_and_detective, R.color.cat_mystery_and_detective),
        Category(R.string.cat_science_fiction, R.color.cat_science_fiction),
        Category(R.string.cat_fantasy, R.color.cat_fantasy),
        Category(R.string.cat_romance, R.color.cat_romance),
        Category(R.string.cat_young_adult, R.color.cat_young_adult),
        Category(R.string.cat_self_help, R.color.cat_self_help)
    )

}