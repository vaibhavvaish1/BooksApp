package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    @SerialName("finskyOfferType")
    val finskyOfferType: Int,
    @SerialName("listPrice")
    val listPrice: ListPriceX,
    @SerialName("retailPrice")
    val retailPrice: RetailPrice
)