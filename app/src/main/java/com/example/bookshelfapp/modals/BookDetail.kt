package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetail(
    @SerialName("accessInfo")
    val accessInfo: AccessInfoX,
    @SerialName("etag")
    val etag: String,
    @SerialName("id")
    val id: String,
    @SerialName("kind")
    val kind: String,
    @SerialName("saleInfo")
    val saleInfo: SaleInfoX,
    @SerialName("selfLink")
    val selfLink: String,
    @SerialName("volumeInfo")
    val volumeInfo: VolumeInfoX
)