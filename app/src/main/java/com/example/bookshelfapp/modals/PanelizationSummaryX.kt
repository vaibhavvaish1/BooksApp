package com.example.bookshelfapp.modals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummaryX(
    @SerialName("containsEpubBubbles")
    val containsEpubBubbles: Boolean,
    @SerialName("containsImageBubbles")
    val containsImageBubbles: Boolean
)