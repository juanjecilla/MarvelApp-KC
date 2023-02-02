package com.keepcoding.marvelapp.data.repository.remote.responses

data class NetworkSerie(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: NetworkThumbnailData,
    val startYear: Int,
    val endYear: Int,
)
