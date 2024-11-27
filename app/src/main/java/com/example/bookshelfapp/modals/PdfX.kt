package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PdfX(
    @SerialName("acsTokenLink")
    val acsTokenLink: String,
    @SerialName("isAvailable")
    val isAvailable: Boolean
)