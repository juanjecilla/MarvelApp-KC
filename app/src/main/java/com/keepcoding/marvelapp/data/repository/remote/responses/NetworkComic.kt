package com.keepcoding.marvelapp.data.repository.remote.responses

data class NetworkComic(
    val id: Int,
    val title: String,
    val pageCount: Int,
    val thumbnail: NetworkThumbnailData
)
