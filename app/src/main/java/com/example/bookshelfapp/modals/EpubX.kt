package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpubX(
    @SerialName("isAvailable")
    val isAvailable: Boolean
)