package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    @SerialName("acsTokenLink")
    val acsTokenLink: String,
    @SerialName("isAvailable")
    val isAvailable: Boolean
)