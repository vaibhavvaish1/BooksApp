package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleInfo(
    @SerialName("buyLink")
    val buyLink: String,
    @SerialName("country")
    val country: String,
    @SerialName("isEbook")
    val isEbook: Boolean,
    @SerialName("listPrice")
    val listPrice: ListPrice,
    @SerialName("offers")
    val offers: List<Offer>,
    @SerialName("retailPrice")
    val retailPrice: RetailPriceX,
    @SerialName("saleability")
    val saleability: String
)