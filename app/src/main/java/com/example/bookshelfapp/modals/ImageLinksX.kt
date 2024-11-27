package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinksX(
    @SerialName("extraLarge")
    val extraLarge: String,
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("small")
    val small: String,
    @SerialName("smallThumbnail")
    val smallThumbnail: String,
    @SerialName("thumbnail")
    val thumbnail: String
)