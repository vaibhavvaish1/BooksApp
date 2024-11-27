package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OfferX(
    @SerialName("finskyOfferType")
    val finskyOfferType: Int,
    @SerialName("listPrice")
    val listPrice: ListPriceXXX,
    @SerialName("retailPrice")
    val retailPrice: RetailPriceXX
)