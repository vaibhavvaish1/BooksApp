package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessInfoX(
    @SerialName("accessViewStatus")
    val accessViewStatus: String,
    @SerialName("country")
    val country: String,
    @SerialName("embeddable")
    val embeddable: Boolean,
    @SerialName("epub")
    val epub: EpubX,
    @SerialName("pdf")
    val pdf: PdfX,
    @SerialName("publicDomain")
    val publicDomain: Boolean,
    @SerialName("quoteSharingAllowed")
    val quoteSharingAllowed: Boolean,
    @SerialName("textToSpeechPermission")
    val textToSpeechPermission: String,
    @SerialName("viewability")
    val viewability: String,
    @SerialName("webReaderLink")
    val webReaderLink: String
)