package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaleInfoX(
    @SerialName("buyLink")
    val buyLink: String,
    @SerialName("country")
    val country: String,
    @SerialName("isEbook")
    val isEbook: Boolean,
    @SerialName("listPrice")
    val listPrice: ListPriceXX,
    @SerialName("offers")
    val offers: List<OfferX>,
    @SerialName("retailPrice")
    val retailPrice: RetailPriceXXX,
    @SerialName("saleability")
    val saleability: String
)