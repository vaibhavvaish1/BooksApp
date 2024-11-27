package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfoX(
    @SerialName("allowAnonLogging")
    val allowAnonLogging: Boolean,
    @SerialName("authors")
    val authors: List<String>,
    @SerialName("canonicalVolumeLink")
    val canonicalVolumeLink: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("contentVersion")
    val contentVersion: String,
    @SerialName("description")
    val description: String,
    @SerialName("imageLinks")
    val imageLinks: ImageLinksX,
    @SerialName("industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifierX>,
    @SerialName("infoLink")
    val infoLink: String,
    @SerialName("language")
    val language: String,
    @SerialName("maturityRating")
    val maturityRating: String,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("panelizationSummary")
    val panelizationSummary: PanelizationSummaryX,
    @SerialName("previewLink")
    val previewLink: String,
    @SerialName("printType")
    val printType: String,
    @SerialName("printedPageCount")
    val printedPageCount: Int,
    @SerialName("publishedDate")
    val publishedDate: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("readingModes")
    val readingModes: ReadingModesX,
    @SerialName("title")
    val title: String
)