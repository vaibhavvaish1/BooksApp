package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListPriceXXX(
    @SerialName("amountInMicros")
    val amountInMicros: Int,
    @SerialName("currencyCode")
    val currencyCode: String
)