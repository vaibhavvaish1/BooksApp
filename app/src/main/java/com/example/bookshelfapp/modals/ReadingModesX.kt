package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadingModesX(
    @SerialName("image")
    val image: Boolean,
    @SerialName("text")
    val text: Boolean
)