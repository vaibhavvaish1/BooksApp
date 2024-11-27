package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifierX(
    @SerialName("identifier")
    val identifier: String,
    @SerialName("type")
    val type: String
)