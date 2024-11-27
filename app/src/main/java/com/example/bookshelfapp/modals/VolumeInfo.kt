package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    @SerialName("allowAnonLogging")
    val allowAnonLogging: Boolean,
    @SerialName("authors")
    val authors: List<String>,
    @SerialName("averageRating")
    val averageRating: Int,
    @SerialName("canonicalVolumeLink")
    val canonicalVolumeLink: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("contentVersion")
    val contentVersion: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageLinks")
    val imageLinks: ImageLinks,
    @SerialName("industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>,
    @SerialName("infoLink")
    val infoLink: String,
    @SerialName("language")
    val language: String,
    @SerialName("maturityRating")
    val maturityRating: String,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("panelizationSummary")
    val panelizationSummary: PanelizationSummary,
    @SerialName("previewLink")
    val previewLink: String,
    @SerialName("printType")
    val printType: String,
    @SerialName("publishedDate")
    val publishedDate: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("ratingsCount")
    val ratingsCount: Int,
    @SerialName("readingModes")
    val readingModes: ReadingModes,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("title")
    val title: String
)