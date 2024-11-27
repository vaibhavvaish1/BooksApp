package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListPriceXX(
    @SerialName("amount")
    val amount: Double,
    @SerialName("currencyCode")
    val currencyCode: String
)